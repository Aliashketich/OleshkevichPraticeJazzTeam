package util.queue;

import exception.MyException;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
import static util.queue.QueueTaskUtils.checkCorrectInputQueue;


public class QueueTaskUtilsTest {

    private PriorityQueue<Integer> notEmptyQueue = new PriorityQueue<>();


    @Test(expected = MyException.class)
    public void checkCorrectInputQueueBothQueueIsEmptyTest() throws MyException {
        checkCorrectInputQueue(new PriorityQueue<Integer>(), new PriorityQueue<Integer>());
    }

    @Test(expected = MyException.class)
    public void checkCorrectInputQueueOneQueueIsEmptyTest() throws MyException {
        notEmptyQueue.add(1);
        checkCorrectInputQueue(new PriorityQueue<Integer>(), notEmptyQueue);
    }

    @Test
    public void insertQueueMergeTwoEmptyQueueTest() {
        assertEquals(new PriorityQueue<Integer>().toString(), QueueTaskUtils.insertQueue(new PriorityQueue<Integer>(), new PriorityQueue<Integer>()).toString());
    }

    @Test
    public void insertQueueMergeOneEmptyQueueTest() {
        notEmptyQueue.add(1);
        assertEquals(notEmptyQueue.toString(), QueueTaskUtils.insertQueue(new PriorityQueue<Integer>(), notEmptyQueue).toString());
    }

}