package tasks.collections.arrayListTask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayListTaskTest {
    private ArrayListTask arrayListTask;
    private ArrayList<String> arrayListWithTestValues = new ArrayList<>();


    @Before
    public void setUp() {
        arrayListTask = new ArrayListTask();
        arrayListWithTestValues.add(0, "word One");
        arrayListWithTestValues.add(1, "word Two");
        arrayListWithTestValues.add(2, "word Three");
        arrayListWithTestValues.add(3, "Four");
        arrayListWithTestValues.add(4, "word Five");
        arrayListWithTestValues.add(5, "word Six");
        arrayListWithTestValues.add(6, "word Seven");
        arrayListWithTestValues.add(7, "word Eight");
        arrayListWithTestValues.add(8, "Nine");
        arrayListWithTestValues.add(9, "word NinePlusOne");
    }

    @Test
    public void selectionByKeywordAndStringLengthResultTest() {
        ArrayList<String> expectedSelectedArrayList = new ArrayList<>();
        expectedSelectedArrayList.add(0, "word Three");
        expectedSelectedArrayList.add(1, "word Five");
        expectedSelectedArrayList.add(2, "word Seven");
        expectedSelectedArrayList.add(3, "word Eight");
        expectedSelectedArrayList.add(4, "word NinePlusOne");
        assertEquals(expectedSelectedArrayList, arrayListTask.selectionByKeywordAndStringLength(arrayListWithTestValues, "word", 9));
    }

    @Test
    public void selectionByKeywordAndNegativeStringLengthTest() {
        assertEquals(arrayListWithTestValues, arrayListTask.selectionByKeywordAndStringLength(arrayListWithTestValues, "word", -1));
    }

    @Test
    public void selectionByNonexistentKeywordAndCorrectStringLengthTest() {
        assertEquals(new ArrayList<>(), arrayListTask.selectionByKeywordAndStringLength(arrayListWithTestValues, "death", 5));
    }

    @Test(expected = NullPointerException.class)
    public void selectionFromNullArrayListTest() {
        arrayListTask.selectionByKeywordAndStringLength(null, "qwerty", 2);
    }
}