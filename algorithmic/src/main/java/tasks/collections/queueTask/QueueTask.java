package tasks.collections.queueTask;

import exception.MyException;

import java.util.PriorityQueue;

import static util.queue.QueueTaskUtils.*;

/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
class QueueTask {

    PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws MyException {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<>();

        checkCorrectInputQueue(firstQueue, secondQueue);

        insertQueue(mergedQueue, firstQueue);
        insertQueue(mergedQueue, secondQueue);

        return sortQueueByAscending(mergedQueue);
    }
}
