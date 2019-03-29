package CollectionTask;

import org.apache.log4j.Logger;
import org.junit.*;

import java.util.PriorityQueue;

public class CollectionTaskTest {
    private static final Logger logger = Logger.getLogger(CollectionTaskTest.class);
    private CollectionTask collectionTask;

    private PriorityQueue<Integer> firstQueue;
    private PriorityQueue<Integer> secondQueue;
    private PriorityQueue<Integer> actualQueue;
    private PriorityQueue<Integer> expectedQueue;

    @BeforeClass
    public static void beforeClass() {
        logger.info("Before StringTask.class");
    }

    @AfterClass
    public static void afterClass() {
        logger.info("After StringTask.class");
    }

    @Before
    public void setUp() throws Exception {
        collectionTask = new CollectionTask();
        firstQueue = new PriorityQueue<Integer>();
        {
            firstQueue.add(1);
            firstQueue.add(3);
            firstQueue.add(5);
            firstQueue.add(7);
        }
        secondQueue = new PriorityQueue<Integer>();
        {
            secondQueue.add(2);
            secondQueue.add(4);
            secondQueue.add(6);
        }
        actualQueue = new PriorityQueue<Integer>();
        {
            actualQueue.add(1);
            actualQueue.add(2);
            actualQueue.add(3);
            actualQueue.add(4);
            actualQueue.add(5);
            actualQueue.add(6);
            actualQueue.add(7);
        }
        expectedQueue = collectionTask.mergeTwoQueue(firstQueue, secondQueue);
    }

    @Test
    public void incorrectMerge() throws Exception {
        logger.info("Test name: incorrectMerge");

        if (expectedQueue.size() == actualQueue.size()) {
            Assert.assertNotEquals(expectedQueue, actualQueue);
        } else {
            logger.error("Arrays are different lengths");
            Assert.fail("Arrays are different lengths");
        }
    }

    @Test
    public void mergeTwoQueueIsNoNull() throws Exception {
        logger.info("Test name: mergeTwoQueueIsNoNull");
        Assert.assertNotNull(expectedQueue.toArray());
    }

    @Test
    public void primaryQueueIsNull() throws Exception {
        logger.info("Test name: primaryQueueIsNull");
        /*@// TODO: 28.03.2019 разобраться что это и почему не хочет видеть это из @Before */
        firstQueue = new PriorityQueue<Integer>();
        {
            firstQueue.add(1);
            firstQueue.add(3);
            firstQueue.add(5);
            firstQueue.add(7);
        }
        secondQueue = new PriorityQueue<Integer>();
        {
            secondQueue.add(2);
            secondQueue.add(4);
            secondQueue.add(6);
        }
        if (firstQueue.size() == 0) {
            logger.info("FirstQueue size is 0");
            Assert.fail("FirstQueue size is 0");
        }
        if (secondQueue.size() == 0) {
            logger.info("SecondQueue size is 0");
            Assert.fail("SecondQueue size is 0");
        }
    }

    @Ignore("Test has been ignored.")
    @Test
    public void ignoredTest() {
        logger.info("will not print it");
    }
}