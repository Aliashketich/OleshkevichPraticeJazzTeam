package util.queue;

import exception.MyException;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;


public class QueueTaskUtilsTest {

    private PriorityQueue<Integer> firstEmptyQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> secondEmptyQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> secondNotEmptyQueue = new PriorityQueue<>();


    @Test(expected = MyException.class)
    public void checkCorrectInputQueueBothQueueIsEmptyTest() throws MyException {
        QueueTaskUtils.checkCorrectInputQueue(firstEmptyQueue, secondEmptyQueue);
    }

    @Test(expected = MyException.class)
    public void checkCorrectInputQueueOneQueueIsEmptyTest() throws MyException {
        secondNotEmptyQueue.add(1);
        QueueTaskUtils.checkCorrectInputQueue(firstEmptyQueue, secondNotEmptyQueue);
    }

    @Test
    public void insertQueueMergeTwoEmptyQueueTest() {
        PriorityQueue<Integer> expectedEmptyQueue = new PriorityQueue<>();
        assertEquals(expectedEmptyQueue.toString(), QueueTaskUtils.insertQueue(firstEmptyQueue, secondEmptyQueue).toString());
    }
    @Test
    public void insertQueueMergeOneEmptyQueueTest() {
        secondNotEmptyQueue.add(1);
        assertEquals(secondNotEmptyQueue.toString(), QueueTaskUtils.insertQueue(firstEmptyQueue, secondNotEmptyQueue).toString());
    }

}