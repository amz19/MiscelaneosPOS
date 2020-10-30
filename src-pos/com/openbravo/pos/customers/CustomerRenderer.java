package com.openbravo.pos.customers;

import javax.swing.*;
import java.awt.*;

public class CustomerRenderer extends DefaultListCellRenderer {
                
    private Icon icocustomer;

    /** Creates a new instance of ProductRenderer */
    public CustomerRenderer() {

        icocustomer = new ImageIcon(getClass().getClassLoader().getResource("com/openbravo/images/kdmconfig.png"));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        setText(value.toString());
        setIcon(icocustomer);
        return this;
    }      
}