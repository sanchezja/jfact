package uk.ac.manchester.cs.jfact.kernel;

/* This file is part of the JFact DL reasoner
 Copyright 2011-2013 by Ignazio Palmisano, Dmitry Tsarkov, University of Manchester
 This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.reasoner.FreshEntityPolicy;

import uk.ac.manchester.cs.jfact.helpers.Helper;
import uk.ac.manchester.cs.jfact.kernel.options.JFactReasonerConfiguration;
import conformance.Original;

/** class for collect TNamedEntry'es together. Template parameter should be
 * inherited from TNamedEntry. Implemented as vector of T*, with Base[i].getId()
 * == i.
 * 
 * @param <T>
 *            type */
public class NamedEntryCollection<T extends NamedEntry> implements Serializable {
    private static final long serialVersionUID = 11000L;
    /** vector of elements */
    private final List<T> base = new ArrayList<T>();
    /** nameset to hold the elements */
    private final NameSet<T, IRI> nameset;
    /** name of the type */
    private final String typeName;
    /** flag to lock the nameset (ie, prohibit to add new names there) */
    private boolean locked;
    @Original
    private final JFactReasonerConfiguration options;

    /** abstract method for additional tuning of newly created element
     * 
     * @param p
     *            p */
    public void registerNew(@SuppressWarnings("unused") T p) {}

    /** new element in a collection;
     * 
     * @param p
     *            p
     * @return this element */
    public T registerElem(T p) {
        p.setId(base.size());
        base.add(p);
        registerNew(p);
        return p;
    }

    /** c'tor: clear 0-th element
     * 
     * @param name
     *            name
     * @param creator
     *            creator
     * @param options
     *            options */
    public NamedEntryCollection(String name, NameCreator<T, IRI> creator,
            JFactReasonerConfiguration options) {
        typeName = name;
        locked = false;
        base.add(null);
        nameset = new NameSet<T, IRI>(creator);
        this.options = options;
    }

    /** @return check if collection is locked */
    public boolean isLocked() {
        return locked;
    }

    /** set LOCKED value to a VAL;
     * 
     * @param val
     *            val
     * @return old value of LOCKED */
    public boolean setLocked(boolean val) {
        boolean old = locked;
        locked = val;
        return old;
    }

    // add/remove elements
    /** @param name
     *            name
     * @return check if entry with a NAME is registered in given collection */
    public boolean isRegistered(IRI name) {
        return nameset.get(name) != null;
    }

    /** @param name
     *            name
     * @return get entry by NAME from the collection; register it if necessary */
    public T get(IRI name) {
        T p = nameset.get(name);
        // check if name is already defined
        if (p != null) {
            return p;
        }
        // check if it is possible to insert name
        if (isLocked() && !options.isUseUndefinedNames()
                && options.getFreshEntityPolicy() == FreshEntityPolicy.DISALLOW) {
            throw new ReasonerFreshEntityException("Unable to register '" + name
                    + "' as a " + typeName, name.toString());
        }
        // create name in name set, and register it
        p = registerElem(nameset.add(name));
        // if fresh entity -- mark it System
        if (isLocked()) {
            p.setSystem();
            if (p instanceof ClassifiableEntry) {
                ((ClassifiableEntry) p).setNonClassifiable(true);
            }
        }
        return p;
        /** / name in name set, and it */
        // return registerElem(nameset.add(name));
    }

    /** remove given entry from the collection;
     * 
     * @param p
     *            p
     * @return true iff it was NOT the last entry. */
    public boolean remove(T p) {
        if (!isRegistered(p.getName())) {
            // not in a name-set: just delete it
            return false;
        }
        // we might delete vars in order (6,7), so the resize should be done to
        // 6
        if (p.getId() > 0 && base.size() > p.getId()) {
            Helper.resize(base, p.getId());
        }
        nameset.remove(p.getName());
        return false;
    }

    // access to elements
    /** @return list of elements */
    public List<T> getList() {
        return base.subList(1, base.size());
    }

    /** @return size */
    public int size() {
        return base.size() - 1;
    }
}
