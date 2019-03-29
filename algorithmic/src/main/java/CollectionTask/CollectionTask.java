/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
package CollectionTask;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.PriorityQueue;

class CollectionTask {
    private static final Logger logger = Logger.getLogger(CollectionTask.class);

    PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws Exception {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> sortedMergedQueue = new PriorityQueue<Integer>();

        if (firstQueue.size() == 0 && secondQueue.size() == 0) {
            logger.error("Both queue is null");
            return null;
        }

        if (firstQueue.size() == 0 || secondQueue.size() == 0) {
            logger.error("One of primary queues is null");
            if (firstQueue.size() == 0)
                return secondQueue;
            if (secondQueue.size() == 0)
                return firstQueue;
        }


        while (!firstQueue.isEmpty())
            mergedQueue.add(firstQueue.poll());
        while (!secondQueue.isEmpty())
            mergedQueue.add(secondQueue.poll());

        Integer[] intArray = new Integer[mergedQueue.size()];
        mergedQueue.toArray(intArray);
        Arrays.sort(intArray);
        sortedMergedQueue.addAll(Arrays.asList(intArray).subList(0, mergedQueue.size()));

        return sortedMergedQueue;
    }
}
