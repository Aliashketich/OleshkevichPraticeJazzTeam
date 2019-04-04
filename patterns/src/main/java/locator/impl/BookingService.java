package locator.impl;

import locator.Service;

public class BookingService implements Service {

    private static final String BOOKING_SERVICE = "BookingService";
    private static final String BOOKING = "Booking";

    public String getServiceName() {
        return BOOKING_SERVICE;
    }

    public String findService() {
        return BOOKING;
    }
}