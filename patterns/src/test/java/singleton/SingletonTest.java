package singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingletonTest {
    @Test
    public void singletonGetInstanceTest() {
        Singleton singleton = Singleton.getInstance();
        assertNotNull(singleton);
    }

    @Test
    public void singletonObjectsIsEqualsTest() {
        Singleton singletonFirst = Singleton.getInstance();
        Singleton singletonSecond = Singleton.getInstance();
        assertEquals(singletonFirst, singletonSecond);
    }
}