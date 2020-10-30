package com.openbravo.pos.payment;

public class MagCardReaderGeneric implements MagCardReader {

    private MagCardParser magcardparser;
    
    /** Creates a new instance of GenericMagCardReader */
    public MagCardReaderGeneric() {
        magcardparser = new MagCardParserGeneric();
    }

    @Override
    public String getReaderName() {
        return "Basic magnetic card reader";
    }
    @Override
    public void keyPressed(java.awt.event.KeyEvent evt) {
    }
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
    }
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        magcardparser.append(evt.getKeyChar());
    }
    @Override
    public MagCardParser getMagCard() {
        return magcardparser;
    }
}