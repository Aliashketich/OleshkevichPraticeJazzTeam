package iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CarIteratorTest {
    private Car car = new Car();

    private Iterator iterator = new CarIterator(car);

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void carIteratorExistTest() {
        assertNotNull(iterator);
    }

    @Test
    public void carIteratorHasNextPartTest() {
        assertTrue(iterator.hasNext());
    }

    @Test
    public void gettingPartIsPossibleTest() {
        Object object = iterator.next();
        assertNotNull(object);
    }

    @Test
    public void carIteratorHasPartAfterBodyTest() {
        Iterator iterator = new CarIterator(car);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertFalse(iterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void carIteratorRemoveMethodTest() {
        Iterator iterator = new CarIterator(car);
        while (true) {
            iterator.remove();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void carIteratorRemoveBodyMethodTest() {
        Iterator iterator = new CarIterator(car);
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void carIteratorHaveLimitedCountOfPartTest() {
        while (true) {
            iterator.next();
        }
    }

    @Test
    public void carHasMotorTest() {
        assertTrue(car.hasMotor());
    }

    @Test
    public void carHasWheelTest() {
        assertTrue(car.hasWheel());
    }

}