package tasks.collections.queueTask;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

public class QueueTaskTest {
    private QueueTask queueTask;

    private PriorityQueue<Integer> firstQueue;
    private PriorityQueue<Integer> secondQueue;
    private PriorityQueue<Integer> emptyQueue = new PriorityQueue<>();


    @Before
    public void setUp() {
        queueTask = new QueueTask();
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
    public void mergeTwoQueueCheckResultTest() throws MyException {
        PriorityQueue<Integer> correctQueue = new PriorityQueue<>();
        {
            correctQueue.add(1);
            correctQueue.add(2);
            correctQueue.add(3);
            correctQueue.add(4);
            correctQueue.add(5);
            correctQueue.add(6);
            correctQueue.add(7);
        }
        Assert.assertEquals(correctQueue.toString(), queueTask.mergeTwoQueue(firstQueue, secondQueue).toString());
    }


    @Test(expected = MyException.class)
    public void firstEntryQueueIsEmptyTest() throws MyException {
        Assert.assertEquals("First primary queue is empty!", queueTask.mergeTwoQueue(emptyQueue, secondQueue).toString());

    }

    @Test(expected = MyException.class)
    public void secondEntryQueueIsEmpty() throws MyException {
        Assert.assertEquals("Second primary queue is empty!", queueTask.mergeTwoQueue(firstQueue, emptyQueue).toString());
    }

    @Test(expected = MyException.class)
    public void bothEntryQueueIsEmpty() throws MyException {
        Assert.assertEquals("Both primary queue is empty!", queueTask.mergeTwoQueue(emptyQueue, emptyQueue).toString());
    }
}