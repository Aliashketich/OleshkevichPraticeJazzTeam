package Tasks.Collections.Task1;

import exception.MyException;

import java.util.Arrays;
import java.util.PriorityQueue;

import static util.queue.CheckCorrectQueue.checkCorrectInputQueue;
import static util.queue.InsertionQueueToOtherQueue.insertQueue;

/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
class CollectionTask {

    PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws MyException {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<>();
        try {
            checkCorrectInputQueue(firstQueue, secondQueue);
        } catch (MyException ex) {
            throw ex;
        }
        mergedQueue = insertQueue(mergedQueue, firstQueue);
        mergedQueue = insertQueue(mergedQueue, secondQueue);

        Integer[] intArray = new Integer[mergedQueue.size()];
        mergedQueue.toArray(intArray);
        Arrays.sort(intArray);

        return new PriorityQueue<>(Arrays.asList(intArray).subList(0, mergedQueue.size()));
    }
}
