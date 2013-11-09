package uk.ac.manchester.cs.jfact.kernel;

/* This file is part of the JFact DL reasoner
 Copyright 2011-2013 by Ignazio Palmisano, Dmitry Tsarkov, University of Manchester
 This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA*/
import static uk.ac.manchester.cs.jfact.kernel.InAx.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.manchester.cs.jfact.helpers.DLTree;
import uk.ac.manchester.cs.jfact.helpers.DLTreeFactory;
import uk.ac.manchester.cs.jfact.helpers.LogAdapter;
import conformance.PortedFrom;

/** set of axioms */
@PortedFrom(file = "tAxiomSet.h", name = "TAxiomSet")
public class AxiomSet implements Serializable {
    private static final long serialVersionUID = 11000L;
    /** host TBox that holds all concepts/etc */
    @PortedFrom(file = "tAxiomSet.h", name = "Host")
    protected final TBox tboxHost;
    /** set of axioms that accumilates incoming (and newly created) axioms; Tg */
    @PortedFrom(file = "tAxiomSet.h", name = "Accum")
    private List<Axiom> accumulator = new ArrayList<Axiom>();
    private final LogAdapter absorptionLog;
    /** set of absorption action, in order */
    @PortedFrom(file = "tAxiomSet.h", name = "ActionVector")
    private final List<AbsorptionActions> actions = new ArrayList<AbsorptionActions>();

    /** add already built GCI p */
    @PortedFrom(file = "tAxiomSet.h", name = "insertGCI")
    private void insertGCI(Axiom p) {
        tboxHost.getOptions().getAbsorptionLog().print("\n new axiom (")
                .print(accumulator.size()).print("):", p);
        accumulator.add(p);
    }

    /** insert GCI if new;
     * 
     * @return true iff already exists */
    @PortedFrom(file = "tAxiomSet.h", name = "insertIfNew")
    private boolean insertIfNew(Axiom q) {
        if (!accumulator.contains(q)) {
            insertGCI(q);
            return false;
        }
        return true;
    }

    /** helper that inserts an axiom into Accum;
     * 
     * @return bool if success */
    @PortedFrom(file = "tAxiomSet.h", name = "processNewAxiom")
    protected boolean processNewAxiom(Axiom q) {
        if (q == null) {
            return false;
        }
        if (insertIfNew(q)) {
            return false;
        }
        return true;
    }

    /** @param host */
    public AxiomSet(TBox host) {
        tboxHost = host;
        absorptionLog = tboxHost.getOptions().getAbsorptionLog();
    }

    /** add axiom for the GCI C [= D
     * 
     * @param C
     * @param D */
    @PortedFrom(file = "tAxiomSet.h", name = "addAxiom")
    public void addAxiom(DLTree C, DLTree D) {
        SAbsInput();
        Axiom p = new Axiom(absorptionLog);
        p.add(C);
        p.add(DLTreeFactory.createSNFNot(D));
        insertGCI(p);
    }

    /** get number of (not absorbed) GCIs */
    @PortedFrom(file = "tAxiomSet.h", name = "size")
    private int size() {
        return accumulator.size();
    }

    /** @return true if non-concept aborption were executed */
    @PortedFrom(file = "tAxiomSet.h", name = "wasRoleAbsorptionApplied")
    public boolean wasRoleAbsorptionApplied() {
        return InAx.containsSAbsRApply();
    }

    /** @return GCI of all non-absorbed axioms */
    @PortedFrom(file = "tAxiomSet.h", name = "getGCI")
    public DLTree getGCI() {
        List<DLTree> l = new ArrayList<DLTree>();
        for (Axiom p : accumulator) {
            l.add(p.createAnAxiom(null));
        }
        return DLTreeFactory.createSNFAnd(l);
    }

    /** split given axiom
     * 
     * @return true if any spit happens */
    @PortedFrom(file = "tAxiomSet.h", name = "split")
    protected boolean split(Axiom p) {
        List<Axiom> splitted = p.split();
        if (splitted.isEmpty()) {
            // nothing to split
            return false;
        }
        for (Axiom q : splitted) {
            if (accumulator.contains(q)) {
                // there is already such an axiom in process; delete it
                return false;
            }
        }
        // do the actual insertion if necessary
        for (Axiom q : splitted) {
            insertGCI(q);
        }
        return true;
    }

    /** @return new size */
    @PortedFrom(file = "tAxiomSet.h", name = "absorb")
    public int absorb() {
        // GCIs to process
        List<Axiom> GCIs = new ArrayList<Axiom>();
        // we will change Accum (via split rule), so indexing and compare with
        // size
        for (int i = 0; i < accumulator.size(); i++) {
            Axiom ax = accumulator.get(i);
            tboxHost.getOptions().getAbsorptionLog().print("\nProcessing (").print(i)
                    .print("):");
            if (!absorbGCI(ax)) {
                GCIs.add(ax);
            }
        }
        // clear absorbed and remove them from Accum
        accumulator = GCIs;
        tboxHost.getOptions().getAbsorptionLog().print("\nAbsorption done with ")
                .print(accumulator.size()).print(" GCIs left\n");
        printStatistics();
        return size();
    }

    @PortedFrom(file = "tAxiomSet.h", name = "absorbGCI")
    private boolean absorbGCI(Axiom p) {
        SAbsAction();
        for (AbsorptionActions abs : actions) {
            if (abs.execute(p, this)) {
                return true;
            }
        }
        tboxHost.getOptions().getAbsorptionLog().print(" keep as GCI");
        return false;
    }

    /** @param flags
     * @return false if no absorptions */
    @PortedFrom(file = "tAxiomSet.h", name = "initAbsorptionFlags")
    public boolean initAbsorptionFlags(String flags) {
        actions.clear();
        for (char c : flags.toCharArray()) {
            actions.add(AbsorptionActions.get(c));
        }
        tboxHost.getOptions().getAbsorptionLog().print("Init absorption order as ")
                .print(flags).print("\n");
        return false;
    }

    @PortedFrom(file = "tAxiomSet.h", name = "PrintStatistics")
    private void printStatistics() {
        if (!containsSAbsAction()) {
            return;
        }
        LogAdapter log = tboxHost.getOptions().getAbsorptionLog();
        log.print("\nAbsorption dealt with ").print(getSAbsInput())
                .print(" input axioms\nThere were made ").print(getSAbsAction())
                .print(" absorption actions, of which:");
        if (containsSAbsRepCN()) {
            log.print("\n\t").print(getSAbsRepCN()).print(" concept name replacements");
        }
        if (containsSAbsRepForall()) {
            log.print("\n\t").print(getSAbsRepForall()).print(" universals replacements");
        }
        if (containsSAbsSplit()) {
            log.print("\n\t").print(getSAbsSplit()).print(" conjunction splits");
        }
        if (containsSAbsBApply()) {
            log.print("\n\t").print(getSAbsBApply()).print(" BOTTOM absorptions");
        }
        if (containsSAbsTApply()) {
            log.print("\n\t").print(getSAbsTApply()).print(" TOP absorptions");
        }
        if (containsSAbsCApply()) {
            log.print("\n\t").print(getSAbsCApply()).print(" concept absorption with ")
                    .print(getSAbsCAttempt()).print(" possibilities");
        }
        if (containsSAbsNApply()) {
            log.print("\n\t").print(getSAbsNApply())
                    .print(" negated concept absorption with ").print(getSAbsNAttempt())
                    .print(" possibilities");
        }
        if (containsSAbsRApply()) {
            log.print("\n\t").print(getSAbsRApply())
                    .print(" role domain absorption with ").print(getSAbsRAttempt())
                    .print(" possibilities");
        }
        if (!accumulator.isEmpty()) {
            log.print("\nThere are ").print(accumulator.size()).print(" GCIs left");
        }
    }
}