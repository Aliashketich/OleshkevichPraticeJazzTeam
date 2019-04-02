package util.queue;

import exception.MyException;

import java.util.PriorityQueue;

public class CheckCorrectQueue {
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
}
