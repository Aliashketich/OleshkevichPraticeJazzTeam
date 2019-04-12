package locator;

import locator.impl.BookingService;
import locator.impl.PaymentService;

public class InitialContext {

    private static final String PAYMENT_SERVICE = "PaymentService";
    private static final String BOOKING_SERVICE = "BookingService";

    public Object searchForTheRequiredService(String serviceType) {
        if (serviceType.equals(PAYMENT_SERVICE)) {
            return new PaymentService();
        } else if (serviceType.equals(BOOKING_SERVICE)) {
            return new BookingService();
        }
        return null;
    }
}