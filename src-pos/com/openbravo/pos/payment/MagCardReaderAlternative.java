package com.openbravo.pos.payment;

import java.awt.event.KeyEvent;

public class MagCardReaderAlternative implements MagCardReader {

    private MagCardParser magcardparser;
    private StringBuffer asciiCode = null;

    /** Creates a new instance of GenericMagCardReader */
    public MagCardReaderAlternative() {
        magcardparser = new MagCardParserGeneric();
    }

    @Override
    public String getReaderName() {
        return "Alternative magnetic card reader";
    }
    @Override
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            asciiCode = new StringBuffer();
        }
    }
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            if (asciiCode != null) {
                try {
                    magcardparser.append((char) Integer.parseInt(asciiCode.toString()));
                } catch (NumberFormatException e) {
                    // ignore the entry
                }
            }
            asciiCode = null;
        }
    }
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        if (asciiCode != null && Character.isDigit(evt.getKeyChar())) {
            asciiCode.append(evt.getKeyChar());
        } else if (evt.getKeyChar() == '\n') {
            magcardparser.append(evt.getKeyChar());
        }
    }
    @Override
    public MagCardParser getMagCard() {
        return magcardparser;
    }
}