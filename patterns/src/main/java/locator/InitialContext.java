package locator;

import locator.impl.BookingService;
import locator.impl.PaymentService;

class InitialContext {

    private static final String PAYMENT_SERVICE = "PaymentService";
    private static final String BOOKING_SERVICE = "BookingService";

    Object searchForTheRequiredService(String serviceType) {
        if (serviceType.equalsIgnoreCase(PAYMENT_SERVICE)) {
            return new PaymentService();
        } else if (serviceType.equalsIgnoreCase(BOOKING_SERVICE)) {
            return new BookingService();
        }
        return null;
    }
}