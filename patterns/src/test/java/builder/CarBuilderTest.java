package builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarBuilderTest {
    private Car car;
    private Car carDefault;

    @Before
    public void setUp() {
        carDefault = new CarBuilder().build();
        car = new CarBuilder()
                .buildMark("BMW")
                .buildSpeed(280)
                .buildColor("green").build();
    }

    @Test
    public void builderMarkPositiveTest() {
        assertEquals(car.getMark(), "BMW");
    }

    @Test
    public void defaultBuilderMarkPositiveTest() {
        assertEquals(carDefault.getMark(), "Audi");
    }

    @Test
    public void builderSpeedPositiveTest() {
        assertEquals(car.getSpeed(), 280);
    }

    @Test
    public void defaultBuilderSpeedPositiveTest() {
        assertEquals(carDefault.getSpeed(), 220);
    }

    @Test
    public void builderColorPositiveTest() {
        assertEquals(car.getColor(), "green");
    }

    @Test
    public void defaultBuilderColorPositiveTest() {
        assertEquals(carDefault.getColor(), "red");
    }


    @Test
    public void builderMarkNegativeTest() {
        assertNotEquals(car.getMark(), "Audi");
    }

    @Test
    public void builderSpeedNegativeTest() {
        assertNotEquals(car.getSpeed(), 220);
    }

    @Test
    public void builderColorNegativeTest() {
        assertNotEquals(car.getColor(), "red");
    }

    @Test
    public void defaultBuilderMarkNegativeTest() {
        assertNotEquals(carDefault.getMark(), "lexus");
    }

    @Test
    public void defaultBuilderSpeedNegativeTest() {
        Car carDefault = new CarBuilder().build();
        assertNotEquals(carDefault.getSpeed(), 230);
    }

    @Test
    public void defaultBuilderColorNegativeTest() {
        assertNotEquals(carDefault.getColor(), "black");
    }
}

