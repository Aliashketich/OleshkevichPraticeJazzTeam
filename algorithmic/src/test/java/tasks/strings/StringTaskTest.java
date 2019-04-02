package tasks.strings;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class StringTaskTest {
    private StringTask stringTask;
    private String actualString;
    private String firstString;
    private String secondString;

    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textFiles/tasks/stringTaskTextFiles/stringTransliteration/";

    @Before
    public void setUp() {
        stringTask = new StringTask();
    }

    @Test
    public void transliterationResultTest() throws MyException, IOException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "data.txt";
        actualString = "Praktika eto prekrasno!";
        Assert.assertEquals(stringTask.transliteration(filePath), actualString);
    }

    @Test(expected = FileNotFoundException.class)
    public void primaryTransliterationStringIsNullTest() throws IOException, MyException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "data1.txt";
        stringTask.transliteration(filePath);
    }

    @Test(expected = MyException.class)
    public void transliterationFileIsEmptyTest() throws MyException, IOException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt";
        Assert.assertEquals("Test string must be not empty!", stringTask.transliteration(filePath));
    }

    @Test
    public void transliterationFileContainsOnlyNumbersTest() throws MyException, IOException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "testFileWithNumbers.txt";
        actualString = "1234567890";
        Assert.assertEquals(actualString, stringTask.transliteration(filePath));
    }

    @Test(expected = MyException.class)
    public void transliterationFileContainsLatinSymbolsTest() throws MyException, IOException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "testFileWithLatinSymbols.txt";
        Assert.assertEquals("Test string contains some latin symbols", stringTask.transliteration(filePath));
    }


    @Test
    public void printIdenticalWordsFromTwoStringsResultTest() {
        firstString = "поле лес дом смородина хорошо";
        secondString = "снег скворец лес хорошо тепло";
        actualString = "лес хорошо";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test(expected = NullPointerException.class)
    public void oneOfPrimaryStringIsNull() {
        firstString = null;
        secondString = "снег скворец лес";
        stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString);
    }

    @Test(expected = NullPointerException.class)
    public void bothPrimaryStringsIsNull() {
        firstString = null;
        secondString = null;
        stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString);
    }

    @Test
    public void stringsHaveNotIdenticalWords() {
        firstString = "поле дом смородина";
        secondString = "снег скворец лес хорошо тепло";
        actualString = "";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test
    public void wordsInStringsAreDividedByNotSpaceOnly() {
        firstString = "Ранним утром!хорошо прогуляться не только по лесу, но и вдоль реки.";
        secondString = "Прошлым-утром я не встретил его в лесу.";
        actualString = "утром не лесу";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test
    public void multipleEntryOfIdenticalWord() {
        firstString = "Ранним утром!хорошо  прогуляться не только по по лесу, но и вдоль реки, и по полю.";
        secondString = "Прошлым-утром я не встретил его во по время прогулки по лесу.";
        actualString = "утром не по лесу";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }
}
