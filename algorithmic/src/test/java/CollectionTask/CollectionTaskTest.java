package CollectionTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

public class CollectionTaskTest {


    @Test
    public void initCollectionTaskTest() throws Exception {
        PriorityQueue<Integer> firstQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> secondQueue = new PriorityQueue<Integer>();

        firstQueue.add(1);
        firstQueue.add(3);
        firstQueue.add(5);
        firstQueue.add(7);

        secondQueue.add(2);
        secondQueue.add(4);
        secondQueue.add(6);

        CollectionTask collectionTask = new CollectionTask();
        collectionTask.mergeTwoQueue(firstQueue,secondQueue);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}