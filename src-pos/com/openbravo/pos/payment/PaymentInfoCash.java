package com.openbravo.pos.payment;

import com.openbravo.format.Formats;

public class PaymentInfoCash extends PaymentInfo {
    
    private double m_dPaid;
    private double m_dTotal;
    //////////////
    private double m_dChange;
    //////////////
    
    /** Creates a new instance of PaymentInfoCash */
    ////////////////
    ////////////////public PaymentInfoCash(double dTotal, double dPaid, double dChange) {
    ////////////////
    public PaymentInfoCash(double dTotal, double dPaid) {
        m_dTotal = dTotal;
        m_dPaid = dPaid;
        ////////////////
        ////////////////m_dChange = dChange;
        ////////////////
    }
    
    public PaymentInfo copyPayment(){
        ////////////
        ////////////return new PaymentInfoCash(m_dTotal, m_dPaid, m_dChange);
        ////////////
        return new PaymentInfoCash(m_dTotal, m_dPaid);
    }
    
    public String getName() {
        return "cash";
    }   
    public double getTotal() {
        return m_dTotal;
    }   
    public double getPaid() {
        return m_dPaid;
    }
    ///////////
    public double getChange() {
        return m_dChange;
    }
    //////////
    public String getTransactionID(){
        return "no ID";
    }
    
    public String printPaid() {
        return Formats.CURRENCY.formatValue(new Double(m_dPaid));
    }   
    public String printChange() {
        return Formats.CURRENCY.formatValue(new Double(m_dPaid - m_dTotal));
    }    
}