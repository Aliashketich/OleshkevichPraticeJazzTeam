package Tasks.Arrays.Task1;

import org.apache.log4j.Logger;
import org.junit.*;

public class ArrayTaskTest {
    private static final Logger logger = Logger.getLogger(ArrayTaskTest.class);

    private ArrayTask arrayTask;
    private int[][] actualArray = {
            {3, 3},
            {9, 2},
            {3, 2}
    };
    private int[][] array = {
            {2, 1, 5, 6},
            {3, 3, 1, 3},
            {3, 4, 2, 3},
            {9, 4, 3, 2},
            {3, 3, 5, 2}
    };

    @Before
    public void setUp() {
        arrayTask = new ArrayTask();
    }

    @Test
    public void runArrayTask() {
        logger.info("Test name: runArrayTask.");
        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(array), actualArray);
    }

    @Test
    public void primaryArrayIsNotNull() throws Exception {
        logger.info("Test name: primaryArrayIsNotNull");
        Assert.assertNotNull(array);
    }

    @Test
    public void newArrayIsNotNull() {
        logger.info("Test name: newArrayIsNotNull");
        Assert.assertNotNull(arrayTask.deleteRowAndColumn(array));
    }

    @Test
    public void primaryArrayWithoutNumberOne() {
        logger.info("Test name: primaryArrayWithoutNumberOne");
        int[][] actualArrayFromTest = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };

        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(actualArrayFromTest), actualArrayFromTest);
    }

    @BeforeClass
    public static void beforeClass() {
        logger.info("BeforeClass Strings.class");
    }

    @AfterClass
    public static void afterClass() {
        logger.info("AfterClass Strings.class");
    }

}