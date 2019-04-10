package util.file;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static util.file.FileTaskUtils.*;

public class FileTaskUtilsTest {
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textfiles/filesforutil/filesforfileworkutils/";


    private ArrayList<String> arrayListOfWordWithSetLength = new ArrayList<>();
    private ArrayList<String> testWordsSourceArrayList = new ArrayList<>();

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
        assertEquals("Word length can not be equals zero!", FileTaskUtils.checkRectangleForSatisfaction(arrayListOfWordWithSetLength, new ArrayList<>(), 0));
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


    @Test(expected = FileNotFoundException.class)
    public void readAllStringsFromFileFileNotFoundTest() throws IOException, MyException {
        readAllStringsFromFile("src/data.txt");
    }

    @Test(expected = MyException.class)
    public void readAllStringsFromFileFileIsEmptyTest() throws IOException, MyException {
        assertEquals("Test file is empty!", readAllStringsFromFile(ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt").toString());
    }

    @Test
    public void readAllStringsFromFileWithEmptyFirstStringTest() throws IOException, MyException {
        ArrayList<String> arrayListForTestWithEmptyFirstString = new ArrayList<>();
        arrayListForTestWithEmptyFirstString.add(0, "Two");
        arrayListForTestWithEmptyFirstString.add(1, "Three");
        assertEquals(arrayListForTestWithEmptyFirstString, readAllStringsFromFile(ROOT_FILE_DIRECTORY_PATH + "fileWithEmptyFirstString.txt"));
    }

    @Test(expected = FileNotFoundException.class)
    public void readStringFromFileFileNotFoundTest() throws IOException, MyException {
        readStringFromFile("src/data.txt");
    }

    @Test(expected = MyException.class)
    public void readStringFromFileFileIsEmptyTest() throws IOException, MyException {
        assertEquals("Test string must be not empty!", readStringFromFile(ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt"));
    }

    @Test
    public void readStringFromFileFileContainsSymbolsAndNumbersInStringTest() throws IOException, MyException {
        assertEquals("2314@#$1234$#$qwere##4411-0", readStringFromFile(ROOT_FILE_DIRECTORY_PATH + "fileWithSymbolsAndNumbers.txt"));

    }

    @Test(expected = FileNotFoundException.class)
    public void getVocabularyFromFileFileNotFoundTest() throws IOException, MyException {
        getVocabularyFromFile("src/data.txt");
    }

    @Test(expected = MyException.class)
    public void getVocabularyFromFileFileIsEmptyTest() throws IOException, MyException {
        assertEquals("Vocabulary file is empty!", getVocabularyFromFile(ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt").toString());
    }
}