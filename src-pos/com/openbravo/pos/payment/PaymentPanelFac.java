package com.openbravo.pos.payment;

/**
 *
 */
public class PaymentPanelFac {
    
    /** Creates a new instance of PaymentPanelFac */
    private PaymentPanelFac() {
    }
    
    public static PaymentPanel getPaymentPanel(String sReader, JPaymentNotifier notifier) {
        
        if ("Intelligent".equals(sReader)) {
            return new PaymentPanelMagCard(new MagCardReaderIntelligent(), notifier);
        } else if ("Generic".equals(sReader)) {
            return new PaymentPanelMagCard(new MagCardReaderGeneric(), notifier);
        } else if ("Alternative".equals(sReader)) {
            return new PaymentPanelMagCard(new MagCardReaderAlternative(), notifier);
        } else if ("Keyboard".equals(sReader)) {
            return new PaymentPanelType(notifier);
        } else { // "Not defined
            return new PaymentPanelBasic(notifier);
        }
    }      
}