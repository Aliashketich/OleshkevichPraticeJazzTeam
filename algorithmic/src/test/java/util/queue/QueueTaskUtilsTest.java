package util.queue;

import exception.MyException;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
import static util.queue.QueueTaskUtils.checkCorrectInputQueue;
import static util.queue.QueueTaskUtils.insertQueue;
import static util.queue.QueueTaskUtils.sortQueueByAscending;

public class QueueTaskUtilsTest {

    private PriorityQueue<Integer> notEmptyQueue = new PriorityQueue<>();


    @Test(expected = MyException.class)
    public void checkCorrectInputQueueBothQueueIsEmptyTest() throws MyException {
        checkCorrectInputQueue(new PriorityQueue<>(), new PriorityQueue<>());
    }

    @Test(expected = MyException.class)
    public void checkCorrectInputQueueOneQueueIsEmptyTest() throws MyException {
        notEmptyQueue.add(1);
        checkCorrectInputQueue(new PriorityQueue<>(), notEmptyQueue);
    }

    @Test
    public void insertQueueMergeTwoEmptyQueueTest() {
        assertEquals(new PriorityQueue<Integer>().toString(), insertQueue(new PriorityQueue<>(), new PriorityQueue<Integer>()).toString());
    }

    @Test
    public void insertQueueMergeOneEmptyQueueTest() {
        notEmptyQueue.add(1);
        assertEquals(notEmptyQueue.toString(), insertQueue(new PriorityQueue<>(), notEmptyQueue).toString());
    }

    @Test(expected = NullPointerException.class)
    public void sortQueueByAscendingWhenEntryQueueIsNull(){
        sortQueueByAscending(null);
    }
}