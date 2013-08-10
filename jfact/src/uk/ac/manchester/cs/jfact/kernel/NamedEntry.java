package uk.ac.manchester.cs.jfact.kernel;

import java.io.Serializable;

import uk.ac.manchester.cs.jfact.kernel.dl.interfaces.NamedEntity;
import conformance.Original;
import conformance.PortedFrom;

/* This file is part of the JFact DL reasoner
 Copyright 2011-2013 by Ignazio Palmisano, Dmitry Tsarkov, University of Manchester
 This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA*/
/** named entry */
@PortedFrom(file = "tNamedEntry.h", name = "TNamedEntry")
public abstract class NamedEntry implements HasName, Serializable {
    private static final long serialVersionUID = 11000L;
    /** name of the entry */
    @PortedFrom(file = "tNamedEntry.h", name = "extName")
    protected String extName;
    /** entry identifier */
    @PortedFrom(file = "tNamedEntry.h", name = "extId")
    protected int extId;
    @PortedFrom(file = "tNamedEntry.h", name = "entity")
    protected NamedEntity entity = null;

    /** @param name
     *            entry IRI */
    public NamedEntry(String name) {
        assert name != null;
        extName = name;
        extId = 0;
        if (extName.equals("TOP")) {
            top = true;
        }
        if (extName.equals("BOTTOM")) {
            bottom = true;
        }
    }

    @Override
    @PortedFrom(file = "tNamedEntry.h", name = "getName")
    public String getName() {
        return extName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof NamedEntry) {
            NamedEntry e = (NamedEntry) obj;
            return extName.equals(e.extName) && extId == e.extId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return extName.hashCode();
    }

    /** set internal ID
     * 
     * @param id */
    @PortedFrom(file = "tNamedEntry.h", name = "setId")
    public void setId(int id) {
        extId = id;
    }

    /** @return internal ID */
    @PortedFrom(file = "tNamedEntry.h", name = "getId")
    public int getId() {
        return extId;
    }

    @Override
    public String toString() {
        return extName + " " + extId + " " + entity + " " + bottom + " " + system + " "
                + top;
    }

    @Original
    private boolean system;

    /** @return System flag */
    @Original
    public boolean isSystem() {
        return system;
    }

    /** set as system entry */
    @Original
    public void setSystem() {
        system = true;
    }

    @Original
    private boolean top = false;

    // hierarchy interface
    /** @return Top-of-the-hierarchy flag */
    @Original
    public boolean isTop() {
        return top;
    }

    /** set as top entity */
    @Original
    public void setTop() {
        top = true;
    }

    @Original
    private boolean bottom;

    /** @return Bottom-of-the-hierarchy */
    @Original
    public boolean isBottom() {
        return bottom;
    }

    /** set as bottom entity */
    @Original
    public void setBottom() {
        bottom = true;
    }

    /** @return entity */
    @PortedFrom(file = "tNamedEntry.h", name = "getEntity")
    public NamedEntity getEntity() {
        return entity;
    }

    /** @param entity */
    @PortedFrom(file = "tNamedEntry.h", name = "setEntity")
    public void setEntity(NamedEntity entity) {
        this.entity = entity;
    }

    /** @param i */
    @PortedFrom(file = "taxNamEntry.h", name = "setIndex")
    public abstract void setIndex(int i);

    /** @return index */
    @PortedFrom(file = "taxNamEntry.h", name = "getIndex")
    public abstract int getIndex();
}
