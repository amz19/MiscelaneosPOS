package com.openbravo.pos.printer.escpos;

import java.awt.image.BufferedImage;
import javax.swing.JComponent;

import com.openbravo.pos.printer.*;

public class DevicePrinterPlain implements DevicePrinter  {
    
    private static final byte[] NEW_LINE = {0x0D, 0x0A}; // Print and carriage return
      
    private PrinterWritter out;
    private UnicodeTranslator trans;
    
    // Creates new TicketPrinter
    public DevicePrinterPlain(PrinterWritter CommOutputPrinter) throws TicketPrinterException {

        out = CommOutputPrinter;
        trans = new UnicodeTranslatorStar(); // The star translator stands for the 437 int char page
    }
   
    public String getPrinterName() {
        return "Plain";
    }
    public String getPrinterDescription() {
        return null;
    }   
    public JComponent getPrinterComponent() {
        return null;
    }
    public void reset() {
    }
    
    public void beginReceipt() {
    }
    
    public void printImage(BufferedImage image) {
    }
    
    public void printBarCode(String type, String position, String code) {        
        if (! DevicePrinter.POSITION_NONE.equals(position)) {                
            out.write(code);
            out.write(NEW_LINE);
        }
    }
    
    public void beginLine(int iTextSize) {
    }
    
    public void printText(int iStyle, String sText) {
        out.write(trans.transString(sText));
    }
    
    public void endLine() {
        out.write(NEW_LINE);
    }
    
    public void endReceipt() {       
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.flush();
    }
    
    public void openDrawer() {
    }
}