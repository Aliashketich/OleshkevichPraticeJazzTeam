package locator.impl;

import locator.Service;

public class PaymentService implements Service {

    private static final String PAYMENT_SERVICE = "PaymentService";
    private static final String PAYMENT = "Payment";

    public String getServiceName() {
        return PAYMENT_SERVICE;
    }

    public String findService() {
        return PAYMENT;
    }
}