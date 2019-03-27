/*Даны две упорядоченные очереди, элементами которых являются целые числа.
 Объединить эти очереди в одну упорядоченную очередь*/
package CollectionTask;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CollectionTask {

    public PriorityQueue<Integer> mergeTwoQueue(PriorityQueue<Integer> firstQueue, PriorityQueue<Integer> secondQueue) throws Exception {
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> finalMergedQueue = new PriorityQueue<Integer>();

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
            ex.printStackTrace();
        }
        return finalMergedQueue;
    }
}
