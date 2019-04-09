package locator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceLocatorTest {
    private static final String BOOKING_SERVICE = "BookingService";
    private static final String BOOKING = "Booking";
    private static final String PAYMENT_SERVICE = "PaymentService";
    private static final String PAYMENT = "Payment";

    private static final String NONEXISTENT_SERVICE = "Nonexistent service.";
    private Service bookingService;
    private Service paymentService;

    @Before
    public void setUp() {
        bookingService = ServiceLocator.getService(BOOKING_SERVICE);
        paymentService = ServiceLocator.getService(PAYMENT_SERVICE);

    }

    @Test
    public void serviceLocatorCanFindBookingServiceTest() {
        assertEquals(BOOKING, bookingService.findService());
    }

    @Test
    public void serviceLocatorCanFindPaymentServiceTest() {
        assertEquals(PAYMENT, paymentService.findService());
    }

    @Test
    public void serviceLocatorShouldNotFindBookingServiceWhenPaymentServiceLookTest() {
        assertNotEquals(BOOKING, paymentService.findService());
    }

    @Test
    public void serviceLocatorShouldNotFindPaymentServiceWhenBookingServiceLookTest() {
        assertNotEquals(PAYMENT, bookingService.findService());
    }

    @Test(expected = NullPointerException.class)
    public void serviceLocatorCanNotFindExistentServiceWhenNonexistentServiceLookTest() {
        Service service = ServiceLocator.getService(NONEXISTENT_SERVICE);
        service.findService();
    }

    @Test
    public void getBookingServiceNameTest() {
        assertEquals(BOOKING_SERVICE, bookingService.getServiceName());
    }

    @Test
    public void getPaymentServiceNameTest() {
        assertEquals(PAYMENT_SERVICE, paymentService.getServiceName());
    }

    @Test
    public void paymentServiceFromCacheIsNullTest() {
        Cache cache = new Cache();
        assertNull(cache.getService(PAYMENT_SERVICE));
    }
}