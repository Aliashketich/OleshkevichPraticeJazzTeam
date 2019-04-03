package util.file;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;
import util.file.FileTaskUtils;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FileTaskUtilsTest {

    ArrayList<String> arrayListOfWordWithSetLength = new ArrayList<>();
    ArrayList<String> testWordsSourceArrayList = new ArrayList<>();

    @Before
    public void setUp() {
        testWordsSourceArrayList.add("logo");
        testWordsSourceArrayList.add("same");
        testWordsSourceArrayList.add("sameLength");
        testWordsSourceArrayList.add("sameLenrr11");
        testWordsSourceArrayList.add("sa");
    }

    @Test(expected = MyException.class)
    public void checkRectangleForSatisfactionWordLengthEqualsZeroTest() throws MyException {
        ArrayList<String> rectangleOfWordForCorrectCheck = new ArrayList<>();
        assertEquals("Word length can not be equals zero!", FileTaskUtils.checkRectangleForSatisfaction(arrayListOfWordWithSetLength, rectangleOfWordForCorrectCheck, 0));
    }

    @Test
    public void arrayListHasSomeWordOnThisLetterCharIsNumberTest() {
        assertFalse(FileTaskUtils.arrayListHasSomeWordOnThisLetter(arrayListOfWordWithSetLength, '1', "word"));
    }

    @Test
    public void getNumberOfWordsInGroupTest() {
        HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength = new HashMap<>();
        ArrayList<String> stringArrayListWithTestValues = new ArrayList<>();
        stringArrayListWithTestValues.add("word");
        stringArrayListWithTestValues.add("same");
        stringArrayListWithTestValues.add("logo");
        wordsGroupWithSameLength.put(3, stringArrayListWithTestValues);
        assertEquals(3, FileTaskUtils.getNumberOfWordsInGroup(wordsGroupWithSameLength, 3));
    }

    @Test
    public void getStringListMinElementLengthTest() {
        assertEquals(2, FileTaskUtils.getStringListMinElementLength(testWordsSourceArrayList));
    }

    @Test
    public void getStringListMaxElementLengthTest() {
        assertEquals(11, FileTaskUtils.getStringListMaxElementLength(testWordsSourceArrayList));
    }
}