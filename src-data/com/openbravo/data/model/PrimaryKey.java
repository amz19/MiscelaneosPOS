package com.openbravo.data.model;

/**
 *
 */
public class PrimaryKey extends Column {
    
    public PrimaryKey(String name) {
        super(name);
    }
    
    public boolean isPK() {
        return true;
    }
}