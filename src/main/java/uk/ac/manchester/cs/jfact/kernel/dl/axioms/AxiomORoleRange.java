package uk.ac.manchester.cs.jfact.kernel.dl.axioms;

import java.util.stream.Stream;

import javax.annotation.Nullable;

/* This file is part of the JFact DL reasoner
 Copyright 2011-2013 by Ignazio Palmisano, Dmitry Tsarkov, University of Manchester
 This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA*/
import org.semanticweb.owlapi.model.OWLAxiom;

import conformance.PortedFrom;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.ConceptExpression;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.Expression;
import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.ObjectRoleExpression;
import uk.ac.manchester.cs.jfact.visitors.DLAxiomVisitor;
import uk.ac.manchester.cs.jfact.visitors.DLAxiomVisitorEx;

/** object role range */
@PortedFrom(file = "tDLAxiom.h", name = "TDLAxiomORoleRange")
public class AxiomORoleRange extends AxiomSingleORole {

    @PortedFrom(file = "tDLAxiom.h", name = "Range") private final ConceptExpression range;

    /**
     * @param ax
     *        ax
     * @param role
     *        role
     * @param range
     *        range
     */
    @PortedFrom(file = "tDLAxiom.h", name = "Range")
    public AxiomORoleRange(OWLAxiom ax, ObjectRoleExpression role, ConceptExpression range) {
        super(ax, role);
        this.range = range;
    }

    @Override
    public Stream<Expression> namedEntitySignature() {
        return Stream.of(role, range);
    }

    @Override
    @PortedFrom(file = "tDLAxiom.h", name = "accept")
    public void accept(DLAxiomVisitor visitor) {
        visitor.visit(this);
    }

    @Nullable
    @Override
    @PortedFrom(file = "tDLAxiom.h", name = "accept")
    public <O> O accept(DLAxiomVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    /** @return range */
    @PortedFrom(file = "tDLAxiom.h", name = "getRange")
    public ConceptExpression getRange() {
        return range;
    }
}
