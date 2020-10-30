package com.openbravo.pos.forms;

import com.openbravo.beans.LocaleResources;

/**
 *
 */
public class AppLocal {
    
    public static final String APP_NAME = "MiscelaneosPOS";
    public static final String APP_ID = "MiscelaneosPOS";
    public static final String APP_VERSION = "2.30.2";
  
    // private static List<ResourceBundle> m_messages;
    private static LocaleResources m_resources;
    
    static {
        m_resources = new LocaleResources();
        m_resources.addBundleName("pos_messages");
        m_resources.addBundleName("erp_messages");
    }
    
    /** Creates a new instance of AppLocal */
    private AppLocal() {
    }
    
    public static String getIntString(String sKey) {
        return m_resources.getString(sKey);
    }
    
    public static String getIntString(String sKey, Object ... sValues) {
        return m_resources.getString(sKey, sValues);
    }
}    