package builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarBuilderTest {
    private Car car;
    private Car defaultCar;

    @Before
    public void setUp() {
        defaultCar = new CarBuilder().constructCar();
        car = new CarBuilder()
                .selectMark("BMW")
                .selectCost(280000)
                .selectColor("White").constructCar();
    }

    @Test
    public void selectMarkIsCorrectTest() {
        assertEquals("BMW", car.getMark());
    }

    @Test
    public void defaultSelectMarkIsCorrectTest() {
        assertEquals("Mercedes", defaultCar.getMark());
    }

    @Test
    public void selectCostIsCorrectTest() {
        assertEquals(280000, car.getCost(), 10);
    }

    @Test
    public void defaultSelectCostIsCorrectTest() {
        assertEquals(220000, defaultCar.getCost(), 10);
    }

    @Test
    public void selectColorIsCorrectTest() {
        assertEquals("White", car.getColor());
    }

    @Test
    public void defaultSelectColorIsCorrectTest() {
        assertEquals("Black", defaultCar.getColor());
    }


    @Test
    public void markNotEqualsDefaultAfterCarBuildingTest() {
        assertNotEquals("Audi", car.getMark());
    }

    @Test
    public void costNotEqualsDefaultAfterCarBuildingTest() {
        assertNotEquals(car.getCost(), 220000);
    }

    @Test
    public void colorNotEqualsDefaultAfterCarBuildingTest() {
        assertNotEquals(car.getColor(), "Black");
    }

    @Test
    public void defaultMarkNotEqualsNonexistentValueTest() {
        assertNotEquals(defaultCar.getMark(), "lexus");
    }

    @Test
    public void defaultCostNotEqualsNonexistentValueTest() {
        assertNotEquals(defaultCar.getCost(), 230000);
    }

    @Test
    public void defaultColorNotEqualsNonexistentValueTest() {
        assertNotEquals(defaultCar.getColor(), "black");
    }
}

