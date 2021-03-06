package util.queue;

import exception.MyException;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QueueTaskUtils {
    public static void checkCorrectInputQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws MyException {
        if (firstQueue.size() == 0 && secondQueue.size() == 0) {
            throw new MyException("Both primary queue is empty!");
        }
        if (firstQueue.size() == 0 || secondQueue.size() == 0) {
            if (firstQueue.size() == 0)
                throw new MyException("First primary queue is empty!");
            else throw new MyException("Second primary queue is empty!");
        }
    }

    public static PriorityQueue<Integer> insertQueue(PriorityQueue<Integer> primaryQueue, PriorityQueue addQueue) {
        while (!addQueue.isEmpty())
            primaryQueue.add((Integer) addQueue.poll());
        return primaryQueue;
    }

    public static PriorityQueue<Integer> sortQueueByAscending(PriorityQueue<Integer> mergedQueue) {
        Integer[] intArray = new Integer[mergedQueue.size()];
        mergedQueue.toArray(intArray);
        Arrays.sort(intArray);
        return new PriorityQueue<>(Arrays.asList(intArray).subList(0, mergedQueue.size()));
    }
}
