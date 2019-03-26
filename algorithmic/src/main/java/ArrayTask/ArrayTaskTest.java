package ArrayTask;

import org.junit.Test;

import java.util.Arrays;


public class ArrayTaskTest {
    @Test
    public void runArrayTask() throws Exception {
        int[][] array = {
                {2,4,5,6,3},
                {1,3,5,3,5},
                {3,4,2,1,3},
                {3,4,3,2,2}
        };
        ArrayTask arrayTask = new ArrayTask(array);

    }
}
