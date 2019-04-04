package locator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ServiceLocatorTest {
    private static final String BOOKING_SERVICE = "BookingService";
    private static final String BOOKING = "Booking";
    private static final String PAYMENT_SERVICE = "PaymentService";
    private static final String PAYMENT = "Payment";

    private static final String NONEXISTENT_SERVICE = "Nonexistent service.";

    @Test
    public void serviceLocatorCanFindBookingServiceTest() {
        Service service = ServiceLocator.getService(BOOKING_SERVICE);
        assertEquals(service.execute(), BOOKING);
    }

    @Test
    public void serviceLocatorCanFindPaymentServiceTest() {
        Service service = ServiceLocator.getService(PAYMENT_SERVICE);
        assertEquals(service.execute(), PAYMENT);
    }

    @Test
    public void serviceLocatorShouldNotFindBookingServiceWhenPaymentServiceLookTest() {
        Service service = ServiceLocator.getService(PAYMENT_SERVICE);
        assertNotEquals(service.execute(), BOOKING);
    }

    @Test
    public void serviceLocatorShouldNotFindPaymentServiceWhenBookingServiceLookTest() {
        Service service = ServiceLocator.getService(BOOKING_SERVICE);
        assertNotEquals(service.execute(), PAYMENT);
    }

    @Test(expected = NullPointerException.class)
    public void serviceLocatorCanNotFindExistentServiceWhenNonexistentServiceLookTest() {
        Service service = ServiceLocator.getService(NONEXISTENT_SERVICE);
        service.execute();
    }
}