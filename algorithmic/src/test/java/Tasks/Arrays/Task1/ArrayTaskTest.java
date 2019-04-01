package Tasks.Arrays.Task1;

import exception.MyExceptionForFileWork;
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
    public void runArrayTask() throws MyExceptionForFileWork {
        Assert.assertArrayEquals(arrayTask.deleteRowAndColumn(array), actualArray);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsExceptionProcessing() throws MyExceptionForFileWork {
        int[][] arrayForThisTest = new int[0][];
        arrayTask.deleteRowAndColumn(arrayForThisTest);
    }

    @Test
    public void newArrayIsNotNull() throws MyExceptionForFileWork {
        Assert.assertNotNull(arrayTask.deleteRowAndColumn(array));
    }

    @Test(expected = MyExceptionForFileWork.class)
    public void primaryArrayWithoutNumberOne() throws MyExceptionForFileWork {
        int[][] actualArrayFromTest = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };
        Assert.assertEquals("Primary array haven't 1.", arrayTask.deleteRowAndColumn(actualArrayFromTest));
    }

}