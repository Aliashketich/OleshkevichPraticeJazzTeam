package Tasks.Collections.ArrayListTask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTaskTest {
    private ArrayListTask arrayListTask;
    private ArrayList<String> stringArrayList = new ArrayList<String>();


    @Before
    public void setUp() {
        arrayListTask = new ArrayListTask();
        stringArrayList.add(0, "word One");
        stringArrayList.add(1, "word Two");
        stringArrayList.add(2, "word Three");
        stringArrayList.add(3, "Four");
        stringArrayList.add(4, "word Five");
        stringArrayList.add(5, "word Six");
        stringArrayList.add(6, "word Seven");
        stringArrayList.add(7, "word Eight");
        stringArrayList.add(8, "Nine");
        stringArrayList.add(9, "word NinePlusOne");
    }

    @Test
    public void searchMethodArrayTaskTest() {
        ArrayList<String> expectedArrayList = new ArrayList<String>();
        expectedArrayList.add(0, "word Three");
        expectedArrayList.add(1, "word Five");
        expectedArrayList.add(2, "word Seven");
        expectedArrayList.add(3, "word Eight");
        expectedArrayList.add(4, "word NinePlusOne");
        Assert.assertEquals(expectedArrayList, arrayListTask.search(stringArrayList, "word", 9));
    }

    @Test
    public void searchMethodArrayTaskTestWithSpecialValueOfMinLength() {
        Assert.assertEquals(stringArrayList, arrayListTask.search(stringArrayList, "word", -1));
    }

    @Test
    public void searchMethodArrayTaskTestWithIncorrectValueOfKeyword() {
        ArrayList<String> expectedArrayList = new ArrayList<String>();
        Assert.assertEquals(expectedArrayList, arrayListTask.search(stringArrayList, "death", 5));
    }

    @Test(expected = NullPointerException.class)
    public void indexNullPointerExceptionProcessing() {
        ArrayList<String> nullTestArrayList = null;
        arrayListTask.search(nullTestArrayList, "qwerty", 2);
    }
}