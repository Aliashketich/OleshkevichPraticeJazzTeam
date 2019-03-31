package Tasks.Arrays.Task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTask2Test {
    private ArrayTask2 arrayTask2;

    private int[][] actualArray = {
            {9, 4, 3, 2, 2},
            {5, 4, 2, 3, 2},
            {3, 3, 1, 3, 3},
            {2, 1, 5, 6, 4}
    };
    private int[][] array = {
            {2, 1, 5, 6, 4},
            {3, 3, 1, 3, 3},
            {5, 4, 2, 3, 2},
            {9, 4, 3, 2, 2}
    };

    @Before
    public void setUp() {
        arrayTask2 = new ArrayTask2();
    }

    @Test
    public void checkNormalisationResult() {
        Assert.assertArrayEquals(arrayTask2.normalisation(array), actualArray);
    }

    @Test
    public void primaryArrayHasOnlyZeroInFirstColumn() {
        int[][] actual = {
                {0, 1, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 3, 0, 0, 0},
                {0, 4, 0, 0, 0}
        };
        int[][] checkArray = {
                {0, 1, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 3, 0, 0, 0},
                {0, 4, 0, 0, 0}
        };
        Assert.assertArrayEquals(arrayTask2.normalisation(checkArray), actual);
    }

    @Test
    public void primaryArrayIsNull() {
        int[][] checkArray = new int[0][];
        int[][] actual = new int[0][];
        Assert.assertArrayEquals(arrayTask2.normalisation(checkArray), actual);
    }
}