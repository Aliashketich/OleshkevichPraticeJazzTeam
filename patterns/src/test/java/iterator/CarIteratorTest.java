package iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CarIteratorTest {
    private Car car = new Car();

    private Iterator iterator = new CarIterator(car);

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
    public void carIteratorHasPartAfterBody() {
        Car car = new Car();
        Iterator iterator = new CarIterator(car);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertFalse(iterator.hasNext());
    }
}