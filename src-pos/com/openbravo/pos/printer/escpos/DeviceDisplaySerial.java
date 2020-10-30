package com.openbravo.pos.printer.escpos;

import com.openbravo.pos.printer.*;
import com.openbravo.pos.forms.AppLocal;
/**
 *
 */
public abstract class DeviceDisplaySerial implements DeviceDisplay, DeviceDisplayImpl {
    
    private String m_sName;    
    protected PrinterWritter display;  
    
    protected DeviceDisplayBase m_displaylines;
    
    public DeviceDisplaySerial() {
        m_displaylines = new DeviceDisplayBase(this);
    }
    
    protected void init(PrinterWritter display) {                
        m_sName = AppLocal.getIntString("Printer.Serial");
        this.display = display;      
        initVisor();        
    }
   
    public String getDisplayName() {
        return m_sName;
    }    
    public String getDisplayDescription() {
        return null;
    }        
    public javax.swing.JComponent getDisplayComponent() {
        return null;
    }
    
    public void writeVisor(int animation, String sLine1, String sLine2) {
        m_displaylines.writeVisor(animation, sLine1, sLine2);
    }    
    
    public void writeVisor(String sLine1, String sLine2) {        
        m_displaylines.writeVisor(sLine1, sLine2);
    }
     
    public void clearVisor() {
        m_displaylines.clearVisor();
    }
    
    public abstract void initVisor();
}