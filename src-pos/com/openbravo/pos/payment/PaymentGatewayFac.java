package com.openbravo.pos.payment;

import com.openbravo.pos.forms.*;

public class PaymentGatewayFac {
    
    /** Creates a new instance of PaymentGatewayFac */
    private PaymentGatewayFac() {
    }
    
    public static PaymentGateway getPaymentGateway(AppProperties props) {
        
        String sReader = props.getProperty("payment.gateway");

        if ("external".equals(sReader)) {
            return new PaymentGatewayExt();
        } else if ("PayPoint / SecPay".equals(sReader)) {
            return new PaymentGatewayPayPoint(props);
        } else if ("AuthorizeNet".equals(sReader)) {
            return new PaymentGatewayAuthorizeNet(props);
        } else if ("La Caixa (Spain)".equals(sReader)) {
            return new PaymentGatewayCaixa(props);
        } else if ("Planetauthorize".equals(sReader)) {
            return new PaymentGatewayPlanetauthorize(props);
        } else if ("Firs Data / LinkPoint / YourPay".equals(sReader)) {
            return new PaymentGatewayLinkPoint(props);
        } else if ("PaymentsGateway.net".equals(sReader)) {
            return new PaymentGatewayPGNET(props);
        } else {
            return null;
        }
    }      
}