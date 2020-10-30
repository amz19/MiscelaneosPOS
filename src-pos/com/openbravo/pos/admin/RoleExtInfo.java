package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;

/**
 *
 *
 */
public class RoleExtInfo extends RoleInfo {
    
    protected byte[] m_aPermissions;
    
    /** Creates a new instance of RoleExtInfo */
    public RoleExtInfo() {
        super();
        m_aPermissions = null;
    }
    
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_aPermissions = dr.getBytes(2);
    }   
    
    //  implements Vectorer, ComparatorCreator
    public static String[] getHeaders() {
        return new String[] {"Name"};
    }
    
    public String[] toStringArray() {
        return new String[] {m_sName};
    } 
    public Comparable[] toComparableArray() {
        return new Comparable[] {m_sName};
    }
}