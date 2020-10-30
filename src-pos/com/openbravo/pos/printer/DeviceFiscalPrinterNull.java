package com.openbravo.pos.printer;

import javax.swing.JComponent;

public class DeviceFiscalPrinterNull implements DeviceFiscalPrinter {
    
    /** Creates a new instance of DeviceFiscalPrinterNull */
    public DeviceFiscalPrinterNull() {
    }
    public DeviceFiscalPrinterNull(String desc) {
    }
 
    public String getFiscalName() {
        return null;
    }
    public JComponent getFiscalComponent() {
        return null;
    }
    
    public void beginReceipt() {
    }
    public void endReceipt() {
    }
    public void printLine(String sproduct, double dprice, double dunits, int taxinfo) {
    }
    public void printMessage(String smessage) {
    }
    public void printTotal(String sPayment, double dpaid) {
    }
    
    public void printZReport() {
    }
    public void printXReport() {
    }
}