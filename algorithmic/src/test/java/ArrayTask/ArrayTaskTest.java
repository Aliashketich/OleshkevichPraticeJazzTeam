package ArrayTask;

import org.junit.Test;

public class ArrayTaskTest {
    @Test
    public void runArrayTask() throws Exception {
        int[][] array = {
                {2, 4, 5, 6},
                {3, 3, 1, 3},
                {3, 4, 2, 3},
                {1, 4, 3, 2},
                {3, 3, 5, 2}
        };
        ArrayTask arrayTask = new ArrayTask();
        arrayTask.deleteRowAndColumn(array);

    }
}