package com.openbravo.pos.panels;

import com.openbravo.data.loader.IKeyed;
import com.openbravo.pos.forms.AppLocal;

/**
 *
 *
 */
public class ComboItemLocal implements IKeyed {

    protected Integer m_iKey;
    protected String m_sKeyValue;

    public ComboItemLocal(Integer iKey, String sKeyValue) {
        m_iKey = iKey;
        m_sKeyValue = sKeyValue;
    }
    public Object getKey() {
        return m_iKey;
    }
    public Object getValue() {
        return m_sKeyValue;
    }
    public String toString() {
        return AppLocal.getIntString(m_sKeyValue);
    }
} 