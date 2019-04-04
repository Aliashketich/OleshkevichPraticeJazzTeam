package tasks.collections.queueTask;

import exception.MyException;

import java.util.Arrays;
import java.util.PriorityQueue;

import static util.queue.QueueTaskUtils.checkCorrectInputQueue;
import static util.queue.QueueTaskUtils.insertQueue;

/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
class QueueTask {

    PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws MyException {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<>();

        checkCorrectInputQueue(firstQueue, secondQueue);

        insertQueue(mergedQueue, firstQueue);
        insertQueue(mergedQueue, secondQueue);

        // TODO: 04.04.2019 сделать метод, который принимает mergedQueue, сортирует ее и возвращает PriorityQueue<Integer>
        Integer[] intArray = new Integer[mergedQueue.size()];
        mergedQueue.toArray(intArray);
        Arrays.sort(intArray);

        return new PriorityQueue<>(Arrays.asList(intArray).subList(0, mergedQueue.size()));
    }
}
