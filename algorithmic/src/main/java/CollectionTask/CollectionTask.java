/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
package CollectionTask;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CollectionTask {
    private static final Logger logger = Logger.getLogger(CollectionTask.class);

    public PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws Exception {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> finalMergedQueue = new PriorityQueue<Integer>();
        /**
         * @// TODO: 28.03.2019 Вернуться к этому после задач на тему Exception. */
        if (firstQueue.size() == 0 && secondQueue.size() == 0) {
            logger.error("Both queue is null");
            return null; //Здесь должна быть реализация через Exception.
        }

        if (firstQueue.size() == 0 || secondQueue.size() == 0) {
            logger.error("One of primary queues is null");
            if (firstQueue.size() == 0)
                return secondQueue;
            if (secondQueue.size() == 0)
                return firstQueue;
        }

        try {
            while (!firstQueue.isEmpty())
                mergedQueue.add(firstQueue.poll());
            while (!secondQueue.isEmpty())
                mergedQueue.add(secondQueue.poll());

            Integer[] intArray = new Integer[mergedQueue.size()];
            mergedQueue.toArray(intArray);
            Arrays.sort(intArray);

            for (int i = 0; i < mergedQueue.size(); i++) {
                finalMergedQueue.add(intArray[i]);
            }

        } catch (Exception ex) {
            logger.error("Exception in MergedQueue", ex);
        }
        return finalMergedQueue;
    }
}
