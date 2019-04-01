package util.queueUtil;

import exception.MyExceptionForFileWork;

import java.util.PriorityQueue;

public class CheckCorrectQueue {
    public static void checkCorrectInputQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws MyExceptionForFileWork {
        if (firstQueue.size() == 0 && secondQueue.size() == 0) {
            throw new MyExceptionForFileWork("Both primary queue is empty!");
        }
        if (firstQueue.size() == 0 || secondQueue.size() == 0) {
            if (firstQueue.size() == 0)
                throw new MyExceptionForFileWork("First primary queue is empty!");
            else throw new MyExceptionForFileWork("Second primary queue is empty!");
        }
    }
}
