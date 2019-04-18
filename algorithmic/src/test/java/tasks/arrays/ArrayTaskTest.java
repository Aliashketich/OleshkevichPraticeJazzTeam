package tasks.arrays;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTaskTest {
    private ArrayTask arrayTask;
    private int[][] expectedResult = {
            {3, 3},
            {9, 2},
            {3, 2}
    };
    private int[][] arrayWithOneValues = {
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
    public void deleteRowAndColumnWhichContainsOneValueCheckResultTest() throws MyException {
        assertArrayEquals(expectedResult, arrayTask.deleteRowAndColumnWhichContainsOneValue(arrayWithOneValues));
    }

    @Test(expected = MyException.class)
    public void entryArrayForSortingIsEmptyTest() throws MyException {
        int[][] emptyArray = new int[0][];
        assertEquals("Entry array is empty!", arrayTask.deleteRowAndColumnWhichContainsOneValue(emptyArray));
    }

    @Test
    public void returnedArrayIsNotNull() throws MyException {
        assertNotNull(arrayTask.deleteRowAndColumnWhichContainsOneValue(arrayWithOneValues));
    }

    @Test(expected = MyException.class)
    public void deleteRowAndColumnWhenAllElementsAreOneValueTest() throws MyException {
        int[][] arrayWhenAllElementsAreOneValue = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        assertEquals("Method should delete all elements of arrayWithOneValues because each row has 1", arrayTask.deleteRowAndColumnWhichContainsOneValue(arrayWhenAllElementsAreOneValue));
    }

    @Test(expected = MyException.class)
    public void entryArrayHaveNotOneValuesTest() throws MyException {
        int[][] arrayWithoutOneValues = {
                {2, 4, 5, 6},
                {3, 3, 3, 3},
                {3, 4, 2, 3},
                {9, 4, 3, 2},
                {3, 3, 5, 2}
        };
        assertEquals("Primary arrayWithOneValues haven't 1.", arrayTask.deleteRowAndColumnWhichContainsOneValue(arrayWithoutOneValues));
    }

    @Test
    public void sortingCheckResultTest() {
        int[][] expectedArrayForCheckSortingResultTest = {
                {9, 4, 3, 2, 2},
                {5, 4, 2, 3, 2},
                {3, 3, 1, 3, 3},
                {2, 1, 5, 6, 4}
        };
        int[][] arrayForSorting = {
                {2, 1, 5, 6, 4},
                {3, 3, 1, 3, 3},
                {5, 4, 2, 3, 2},
                {9, 4, 3, 2, 2}
        };
        assertArrayEquals(expectedArrayForCheckSortingResultTest, arrayTask.sortingArrayByDescendingByReshuffleRowsByElementsOfFirstColumn(arrayForSorting));
    }

    @Test
    public void entryArrayHasOnlyZeroValuesInFirstColumnTest() {
        int[][] arrayWithZeroValuesInFirstColumn = {
                {0, 1, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 3, 0, 0, 0},
                {0, 4, 0, 0, 0}
        };
        assertArrayEquals(arrayWithZeroValuesInFirstColumn, arrayTask.sortingArrayByDescendingByReshuffleRowsByElementsOfFirstColumn(arrayWithZeroValuesInFirstColumn));
    }

    @Test(expected = NullPointerException.class)
    public void entryArrayForSortingIsNullTest() {
        arrayTask.sortingArrayByDescendingByReshuffleRowsByElementsOfFirstColumn(null);
    }

    @Test
    public void decreaseElementIfNextHasZeroValueTest() {
        int[] arrayWithAllZeroValues = new int[3];
        arrayWithAllZeroValues[1] = 1;
        int[] expectedArray = new int[3];
        arrayTask.decreaseElementIfNextHasZeroValue(arrayWithAllZeroValues, 0);
        assertArrayEquals(expectedArray, arrayWithAllZeroValues);
    }
}