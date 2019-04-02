package tasks.arrays;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTaskTest {
    private ArrayTask arrayTask;
    private int[][] actualArray = {
            {3, 3},
            {9, 2},
            {3, 2}
    };
    private int[][] array = {
            {2, 1, 5, 6},
            {3, 3, 1, 3},
            {3, 4, 2, 3},
            {9, 4, 3, 2},
            {3, 3, 5, 2}
    };


    @Before
    public void setUp() {
        arrayTask = new ArrayTask();
    }

    @Test
    public void runArrayTask() throws MyException {
        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(array), actualArray);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsExceptionProcessing() throws MyException {
        int[][] emptyArray = new int[0][];
        arrayTask.deleteRowAndColumn(emptyArray);
    }

    @Test
    public void newArrayIsNotNull() throws MyException {
        Assert.assertNotNull(arrayTask.deleteRowAndColumn(array));
    }

    @Test(expected = MyException.class)
    public void deleteRowAndColumnWhenAllElementsAreOneValue() throws MyException {
        int[][] actualArrayFromTest = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        Assert.assertEquals("Method should delete all elements of array because each row has 1",arrayTask.deleteRowAndColumn(actualArrayFromTest));
    }

    @Test(expected = MyException.class)
    public void primaryArrayWithoutNumberOne() throws MyException {
        int[][] actualArrayFromTest = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };
        Assert.assertEquals("Primary array haven't 1.", arrayTask.deleteRowAndColumn(actualArrayFromTest));
    }

    @Test
    public void checkNormalisationResult() {
        int[][] expectedArrayForCheckNormalisationResultTest = {
                {9, 4, 3, 2, 2},
                {5, 4, 2, 3, 2},
                {3, 3, 1, 3, 3},
                {2, 1, 5, 6, 4}
        };
        int[][] testArray = {
                {2, 1, 5, 6, 4},
                {3, 3, 1, 3, 3},
                {5, 4, 2, 3, 2},
                {9, 4, 3, 2, 2}
        };
        Assert.assertArrayEquals(expectedArrayForCheckNormalisationResultTest,arrayTask.normalisation(testArray));
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
        Assert.assertArrayEquals(arrayTask.normalisation(checkArray), actual);
    }

    @Test
    public void primaryArrayIsNull() {
        int[][] checkArray = new int[0][];
        int[][] actual = new int[0][];
        Assert.assertArrayEquals(arrayTask.normalisation(checkArray), actual);
    }

}