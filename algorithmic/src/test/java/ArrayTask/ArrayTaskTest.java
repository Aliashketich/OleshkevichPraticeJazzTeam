package ArrayTask;

import org.apache.log4j.Logger;
import org.junit.*;

public class ArrayTaskTest {
    private static final Logger logger = Logger.getLogger(ArrayTaskTest.class);

    private ArrayTask arrayTask;
    private int[][] actualArray = {
            {3,3},
            {9,2},
            {3,2}
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
    public void runArrayTask() throws Exception {
        logger.info("Имя теста: runArrayTask.");
        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(array), actualArray);
    }

    @Test
    public void primaryArrayIsNotNull() throws Exception {
        logger.info("Имя теста: primaryArrayIsNotNull");
        Assert.assertNotNull(array);
    }

    @Test
    public void newArrayIsNotNull(){
        logger.info("Имя теста: newArrayIsNotNull");
        Assert.assertNotNull(arrayTask.deleteRowAndColumn(array));
    }

    @Test
    public void primaryArrayWithoutNumberOne(){
        logger.info("Имя теста: primaryArrayWithoutNumberOne");
        int[][] actualArrayFromTest = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };
        int[][] arrayFromTest = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };
        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(actualArrayFromTest),arrayFromTest);
    }

    @BeforeClass
    public static void beforeClass() {
        logger.info("BeforeClass StringTask.class");
    }

    @AfterClass
    public static void afterClass() {
        logger.info("AfterClass StringTask.class");
    }

    @Ignore("Test has been ignored.")
    @Test
    public void ignoredTest() {
        logger.info("will not print it");
    }
}