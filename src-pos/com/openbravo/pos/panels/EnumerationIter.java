package com.openbravo.pos.panels;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 */
public class EnumerationIter implements Enumeration {
    
    private Iterator i;

    public EnumerationIter(Iterator i) {
        this.i = i;
    }
    public boolean hasMoreElements() {
        return i.hasNext();
    }
    public Object nextElement() {
        return i.next();
    } 
}