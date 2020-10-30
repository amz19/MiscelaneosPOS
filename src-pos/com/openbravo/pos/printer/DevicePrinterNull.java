package com.openbravo.pos.printer;

import com.openbravo.pos.forms.AppLocal;

public class DevicePrinterNull implements DevicePrinter {
    
    private String m_sName;
    private String m_sDescription;
    
    /** Creates a new instance of DevicePrinterNull */
    public DevicePrinterNull() {
        this(null);
    }
    
    /** Creates a new instance of DevicePrinterNull */
    public DevicePrinterNull(String desc) {
        m_sName = AppLocal.getIntString("Printer.Null");
        m_sDescription = desc;
    }

    public String getPrinterName() {
        return m_sName;
    }    
    public String getPrinterDescription() {
        return m_sDescription;
    }        
    public javax.swing.JComponent getPrinterComponent() {
        return null;
    }
    public void reset() {
    }
    
    public void beginReceipt() {
    }
    public void printBarCode(String type, String position, String code) {        
    }    
    public void printImage(java.awt.image.BufferedImage image) {
    }
    public void beginLine(int iTextSize) {
    }   
    public void printText(int iStyle, String sText) {
    }   
    public void endLine() {
    }
    public void endReceipt() {
    }
    public void openDrawer() {
    }
}