package ArrayTask;

import org.junit.Test;

public class ArrayTaskTest {
    @Test
    public void runArrayTask() throws Exception {
        int[][] array = {
                {2, 4, 5, 6},
                {1, 3, 5, 1},
                {3, 4, 2, 1},
                {3, 4, 3, 2},
                {4, 3, 2, 1}
        };
        ArrayTask arrayTask = new ArrayTask(array);

    }
}