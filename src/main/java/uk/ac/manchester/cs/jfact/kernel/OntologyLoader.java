package uk.ac.manchester.cs.jfact.kernel;

/* This file is part of the JFact DL reasoner
 Copyright 2011-2013 by Ignazio Palmisano, Dmitry Tsarkov, University of Manchester
 This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA*/
import static java.util.stream.Collectors.toList;
import static uk.ac.manchester.cs.jfact.helpers.DLTreeFactory.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.reasoner.InconsistentOntologyException;
import org.semanticweb.owlapi.reasoner.ReasonerInternalException;

import conformance.PortedFrom;
import uk.ac.manchester.cs.jfact.helpers.DLTree;
import uk.ac.manchester.cs.jfact.helpers.DLTreeFactory;
import uk.ac.manchester.cs.jfact.kernel.dl.axioms.*;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.Expression;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.IndividualExpression;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.RoleExpression;
import uk.ac.manchester.cs.jfact.visitors.DLAxiomVisitor;

/** ontology loader */
@PortedFrom(file = "tOntologyLoader.h", name = "TOntologyLoader")
public class OntologyLoader implements DLAxiomVisitor, Serializable {

    private static final long serialVersionUID = 11000L;
    /** KB to load the ontology */
    @PortedFrom(file = "tOntologyLoader.h", name = "kb")
    private final TBox tbox;
    /** Transforms TDLExpression hierarchy to the DLTree */
    @PortedFrom(file = "tOntologyLoader.h", name = "ETrans")
    private final ExpressionTranslator expressionTranslator;

    /**
     * get role by the DLTree; throw exception if unable
     * 
     * @param r
     *        r
     * @param reason
     *        reason
     * @return role
     */
    @PortedFrom(file = "tOntologyLoader.h", name = "getRole")
    private Role getRole(RoleExpression r, String reason) {
        try {
            return Role.resolveRole(r.accept(expressionTranslator));
        } catch (OWLRuntimeException e) {
            throw new ReasonerInternalException(reason + '\t' + e.getMessage(),
                e);
        }
    }

    /**
     * @param I
     *        I
     * @param reason
     *        reason
     * @return an individual be the DLTree; throw exception if unable
     */
    @PortedFrom(file = "tOntologyLoader.h", name = "getIndividual")
    public Individual getIndividual(IndividualExpression I, String reason) {
        try {
            DLTree i = I.accept(expressionTranslator);
            return (Individual) tbox.getCI(i);
        } catch (OWLRuntimeException e) {
            throw new ReasonerInternalException(reason + '\t' + e.getMessage(),
                e);
        }
    }

    /**
     * ensure that the expression EXPR has its named entities linked to the KB
     * ones
     * 
     * @param Expr
     *        Expr
     * @return verified input
     */
    @PortedFrom(file = "tOntologyLoader.h", name = "ensureNames")
    public Expression ensureNames(Expression Expr) {
        assert Expr != null; // TODO temporarily
        return Expr;
    }

    /**
     * prepare arguments for the [begin,end) interval
     * 
     * @param c
     *        c
     * @param <T>
     *        type
     * @return list of arguments
     */
    @PortedFrom(file = "tOntologyLoader.h", name = "prepareArgList")
    private <T extends Expression> List<DLTree> prepareArgList(Collection<T> c) {
        return c.stream().map(t -> ensureNames(t).accept(expressionTranslator))
            .collect(toList());
    }

    @Override
    public void visit(AxiomDeclaration axiom) {
        ensureNames(axiom.getDeclaration());
        // names in the KB
        axiom.getDeclaration().accept(expressionTranslator);
    }

    // n-ary axioms
    @Override
    public void visit(AxiomEquivalentConcepts axiom) {
        tbox.processEquivalentC(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomDisjointConcepts axiom) {
        tbox.processDisjointC(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomEquivalentORoles axiom) {
        tbox.processEquivalentR(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomEquivalentDRoles axiom) {
        tbox.processEquivalentR(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomDisjointORoles axiom) {
        tbox.processDisjointR(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomDisjointDRoles axiom) {
        tbox.processDisjointR(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomDisjointUnion axiom) {
        // first make a disjoint axiom
        tbox.processDisjointC(prepareArgList(axiom.getArguments()));
        // now define C as a union-of axiom
        List<DLTree> ArgList = new ArrayList<>();
        ensureNames(axiom.getConcept());
        ArgList.add(axiom.getConcept().accept(expressionTranslator));
        List<DLTree> list = axiom.getArguments().stream()
            .map(p -> p.accept(expressionTranslator)).collect(toList());
        ArgList.add(createSNFOr(list));
        tbox.processEquivalentC(ArgList);
    }

    @Override
    public void visit(AxiomSameIndividuals axiom) {
        tbox.processSame(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomDifferentIndividuals axiom) {
        tbox.processDifferent(prepareArgList(axiom.getArguments()));
    }

    @Override
    public void visit(AxiomFairnessConstraint axiom) {
        tbox.setFairnessConstraintDLTrees(prepareArgList(axiom.getArguments()));
    }

    // role axioms
    @Override
    public void visit(AxiomRoleInverse axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getInvRole());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Role Inverse axiom");
        Role iR = getRole(axiom.getInvRole(),
            "Role expression expected in Role Inverse axiom");
        tbox.getRM(R);
        RoleMaster.addRoleSynonym(iR.inverse(), R);
    }

    @Override
    public void visit(AxiomORoleSubsumption axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getSubRole());
        DLTree Sub = axiom.getSubRole().accept(expressionTranslator);
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Object Roles Subsumption axiom");
        tbox.getRM(R);
        RoleMaster.addRoleParent(Sub, R);
    }

    @Override
    public void visit(AxiomDRoleSubsumption axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getSubRole());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Data Roles Subsumption axiom");
        Role S = getRole(axiom.getSubRole(),
            "Role expression expected in Data Roles Subsumption axiom");
        tbox.getDRM();
        RoleMaster.addRoleParentProper(S, R);
    }

    @Override
    public void visit(AxiomORoleDomain axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getDomain());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Object Role Domain axiom");
        DLTree C = axiom.getDomain().accept(expressionTranslator);
        if (R.isTop()) {
            // add GCI
            tbox.addSubsumeAxiom(createTop(), C);
        } else if (!R.isBottom()) {
            // nothing to do for bottom
            R.setDomain(C);
        }
    }

    @Override
    public void visit(AxiomDRoleDomain axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getDomain());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Data Role Domain axiom");
        DLTree C = axiom.getDomain().accept(expressionTranslator);
        if (R.isTop()) {
            // add GCI
            tbox.addSubsumeAxiom(createTop(), C);
        } else if (!R.isBottom()) {
            // nothing to do for bottom
            R.setDomain(C);
        }
    }

    @Override
    public void visit(AxiomORoleRange axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getRange());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Object Role Range axiom");
        DLTree C = axiom.getRange().accept(expressionTranslator);
        if (R.isTop()) {
            // add GCI
            tbox.addSubsumeAxiom(createTop(), C);
        } else if (!R.isBottom()) {
            // nothing to do for bottom
            R.setRange(C);
        }
    }

    @Override
    public void visit(AxiomDRoleRange axiom) {
        ensureNames(axiom.getRole());
        ensureNames(axiom.getRange());
        getRole(axiom.getRole(),
            "Role expression expected in Data Role Range axiom").setRange(
                axiom.getRange().accept(expressionTranslator));
    }

    @Override
    public void visit(AxiomRoleTransitive axiom) {
        ensureNames(axiom.getRole());
        Role role = getRole(axiom.getRole(),
            "Role expression expected in Role Transitivity axiom");
        if (!role.isTop() && !role.isBottom()) {
            role.setTransitive(true);
        }
    }

    @Override
    public void visit(AxiomRoleReflexive axiom) {
        ensureNames(axiom.getRole());
        Role role = getRole(axiom.getRole(),
            "Role expression expected in Role Reflexivity axiom");
        if (role.isBottom()) {
            throw new InconsistentOntologyException();
        }
        if (!role.isTop()) {
            role.setReflexive(true);
        }
    }

    @Override
    public void visit(AxiomRoleIrreflexive axiom) {
        ensureNames(axiom.getRole());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Role Irreflexivity axiom");
        if (R.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!R.isBottom()) {
            R.setDomain(createSNFNot(DLTreeFactory.createSNFSelf(axiom
                .getRole().accept(expressionTranslator))));
            R.setDomain(createSNFNot(buildTree(new Lexeme(Token.SELF), axiom
                .getRole().accept(expressionTranslator))));
            R.setIrreflexive(true);
        }
    }

    @Override
    public void visit(AxiomRoleSymmetric axiom) {
        ensureNames(axiom.getRole());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Role Symmetry axiom");
        if (!R.isTop() && !R.isBottom()) {
            R.setSymmetric(true);
            tbox.getORM();
            RoleMaster.addRoleParentProper(R, R.inverse());
        }
    }

    @Override
    public void visit(AxiomRoleAsymmetric axiom) {
        ensureNames(axiom.getRole());
        Role R = getRole(axiom.getRole(),
            "Role expression expected in Role Asymmetry axiom");
        if (R.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!R.isBottom()) {
            R.setAsymmetric(true);
            tbox.getORM().addDisjointRoles(R, R.inverse());
        }
    }

    @Override
    public void visit(AxiomORoleFunctional axiom) {
        ensureNames(axiom.getRole());
        Role role = getRole(axiom.getRole(),
            "Role expression expected in Object Role Functionality axiom");
        if (role.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!role.isBottom()) {
            role.setFunctional();
        }
    }

    @Override
    public void visit(AxiomDRoleFunctional axiom) {
        ensureNames(axiom.getRole());
        Role role = getRole(axiom.getRole(),
            "Role expression expected in Data Role Functionality axiom");
        if (role.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!role.isBottom()) {
            role.setFunctional();
        }
    }

    @Override
    public void visit(AxiomRoleInverseFunctional axiom) {
        ensureNames(axiom.getRole());
        Role role = getRole(axiom.getRole(),
            "Role expression expected in Role Inverse Functionality axiom");
        if (role.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!role.isBottom()) {
            role.inverse().setFunctional();
        }
    }

    // concept/individual axioms
    @Override
    public void visit(AxiomConceptInclusion axiom) {
        ensureNames(axiom.getSubConcept());
        ensureNames(axiom.getSupConcept());
        DLTree C = axiom.getSubConcept().accept(expressionTranslator);
        DLTree D = axiom.getSupConcept().accept(expressionTranslator);
        tbox.addSubsumeAxiom(C, D);
    }

    @Override
    public void visit(AxiomInstanceOf axiom) {
        ensureNames(axiom.getIndividual());
        ensureNames(axiom.getC());
        getIndividual(axiom.getIndividual(),
            "Individual expected in Instance axiom");
        DLTree I = axiom.getIndividual().accept(expressionTranslator);
        DLTree C = axiom.getC().accept(expressionTranslator);
        tbox.addSubsumeAxiom(I, C);
    }

    @Override
    public void visit(AxiomRelatedTo axiom) {
        ensureNames(axiom.getIndividual());
        ensureNames(axiom.getRelation());
        ensureNames(axiom.getRelatedIndividual());
        Role R = getRole(axiom.getRelation(),
            "Role expression expected in Related To axiom");
        if (R.isBottom()) {
            throw new InconsistentOntologyException();
        }
        if (!R.isTop()) {
            Individual I = getIndividual(axiom.getIndividual(),
                "Individual expected in Related To axiom");
            Individual J = getIndividual(axiom.getRelatedIndividual(),
                "Individual expected in Related To axiom");
            tbox.registerIndividualRelation(I, R, J);
        }
    }

    @Override
    public void visit(AxiomRelatedToNot axiom) {
        ensureNames(axiom.getIndividual());
        ensureNames(axiom.getRelation());
        ensureNames(axiom.getRelatedIndividual());
        Role R = getRole(axiom.getRelation(),
            "Role expression expected in Related To Not axiom");
        if (R.isTop()) {
            // inconsistent ontology
            throw new InconsistentOntologyException();
        }
        if (!R.isBottom()) {
            // make sure everything is consistent
            getIndividual(axiom.getIndividual(),
                "Individual expected in Related To Not axiom");
            getIndividual(axiom.getRelatedIndividual(),
                "Individual expected in Related To Not axiom");
            // make an axiom i:AR.\neg{j}
            tbox.addSubsumeAxiom(
                axiom.getIndividual().accept(expressionTranslator),
                createSNFForall(
                    axiom.getRelation().accept(expressionTranslator),
                    createSNFNot(axiom.getRelatedIndividual().accept(
                        expressionTranslator))));
        }
    }

    @Override
    public void visit(AxiomValueOf axiom) {
        ensureNames(axiom.getIndividual());
        ensureNames(axiom.getAttribute());
        getIndividual(axiom.getIndividual(),
            "Individual expected in Value Of axiom");
        Role R = getRole(axiom.getAttribute(),
            "Role expression expected in Value Of axiom");
        if (R.isBottom()) {
            throw new InconsistentOntologyException();
        }
        if (!R.isTop()) {
            // nothing to do for universal role
            // make an axiom i:EA.V
            tbox.addSubsumeAxiom(
                axiom.getIndividual().accept(expressionTranslator),
                createSNFExists(
                    axiom.getAttribute().accept(expressionTranslator),
                    axiom.getValue().accept(expressionTranslator)));
        }
    }

    @Override
    public void visit(AxiomValueOfNot axiom) {
        ensureNames(axiom.getIndividual());
        ensureNames(axiom.getAttribute());
        getIndividual(axiom.getIndividual(),
            "Individual expected in Value Of Not axiom");
        Role R = getRole(axiom.getAttribute(),
            "Role expression expected in Value Of Not axiom");
        if (R.isTop()) {
            throw new InconsistentOntologyException();
        }
        if (!R.isBottom()) {
            // make an axiom i:AA.\neg V
            tbox.addSubsumeAxiom(
                axiom.getIndividual().accept(expressionTranslator),
                createSNFForall(
                    axiom.getAttribute().accept(expressionTranslator),
                    createSNFNot(axiom.getValue().accept(
                        expressionTranslator))));
        }
    }

    /**
     * @param KB
     *        KB
     */
    public OntologyLoader(TBox KB) {
        tbox = KB;
        expressionTranslator = new ExpressionTranslator(KB);
    }

    /**
     * load ontology to a given KB
     * 
     * @param ontology
     *        ontology
     */
    @PortedFrom(file = "tOntologyLoader.h", name = "visitOntology")
    public void visitOntology(Ontology ontology) {
        ontology.getAxioms().stream().filter(p -> p.isUsed())
            .forEach(p -> p.accept(this));
        tbox.finishLoading();
    }
}
