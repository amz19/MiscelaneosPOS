package com.openbravo.pos.forms;

import javax.swing.JComponent;
import com.openbravo.basic.BasicException;

/**
 *
 */
public interface JPanelView {
       
    public abstract String getTitle();
    public abstract void activate() throws BasicException;
    public abstract boolean deactivate();
    public abstract JComponent getComponent();
}