package util.queueUtil;

import java.util.PriorityQueue;

public class InsertionQueueToOtherQueue {
    public static PriorityQueue<Integer> insertQueue(PriorityQueue<Integer> primaryQueue, PriorityQueue addQueue) {
        while (!addQueue.isEmpty())
            primaryQueue.add((Integer) addQueue.poll());
        return primaryQueue;
    }
}
