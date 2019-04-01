package Tasks.Collections.Task1;

import exception.MyExceptionForFileWork;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

public class CollectionTaskTest {
    private CollectionTask collectionTask;

    private PriorityQueue<Integer> firstQueue;
    private PriorityQueue<Integer> secondQueue;
    private PriorityQueue<Integer> expectedQueue;


    @Before
    public void setUp() {
        collectionTask = new CollectionTask();
        firstQueue = new PriorityQueue<>();
        {
            firstQueue.add(1);
            firstQueue.add(3);
            firstQueue.add(5);
            firstQueue.add(7);
        }
        secondQueue = new PriorityQueue<>();
        {
            secondQueue.add(2);
            secondQueue.add(4);
            secondQueue.add(6);
        }
    }

    @Test
    public void mergeTwoQueueIsCorrect() throws MyExceptionForFileWork {
        PriorityQueue<Integer> expectedQueueForThisTest = new PriorityQueue<>();
        {
            expectedQueueForThisTest.add(1);
            expectedQueueForThisTest.add(2);
            expectedQueueForThisTest.add(3);
            expectedQueueForThisTest.add(4);
            expectedQueueForThisTest.add(5);
            expectedQueueForThisTest.add(6);
            expectedQueueForThisTest.add(7);
        }
        Assert.assertEquals(expectedQueueForThisTest.toString(), collectionTask.mergeTwoQueue(firstQueue, secondQueue).toString());
    }


    @Test(expected = MyExceptionForFileWork.class)
    public void firstPrimaryQueueIsNotEmpty() throws MyExceptionForFileWork {
        PriorityQueue<Integer> firstQueueForThisTest = new PriorityQueue<>();
        Assert.assertEquals("First primary queue is empty!", collectionTask.mergeTwoQueue(firstQueueForThisTest, secondQueue).toString());

    }

    @Test(expected = MyExceptionForFileWork.class)
    public void secondPrimaryQueueIsNotEmpty() throws MyExceptionForFileWork {
        PriorityQueue<Integer> secondQueueForThisTest = new PriorityQueue<>();
        Assert.assertEquals("Second primary queue is empty!", collectionTask.mergeTwoQueue(firstQueue, secondQueueForThisTest).toString());
    }

    @Test(expected = MyExceptionForFileWork.class)
    public void bothPrimaryQueueIsNotEmpty() throws MyExceptionForFileWork {
        PriorityQueue<Integer> firstQueueForThisTest = new PriorityQueue<>();
        PriorityQueue<Integer> secondQueueForThisTest = new PriorityQueue<>();
        Assert.assertEquals("Both primary queue is empty!", collectionTask.mergeTwoQueue(firstQueueForThisTest, secondQueueForThisTest).toString());
    }
}