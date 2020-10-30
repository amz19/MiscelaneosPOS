package com.openbravo.pos.payment;

public interface MagCardReader {
 
    public String getReaderName();
    
    public void keyPressed(java.awt.event.KeyEvent evt);
    public void keyReleased(java.awt.event.KeyEvent evt);
    public void keyTyped(java.awt.event.KeyEvent evt);
    public MagCardParser getMagCard();
}