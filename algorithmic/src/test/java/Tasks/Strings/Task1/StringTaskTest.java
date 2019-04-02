package Tasks.Strings.Task1;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class StringTaskTest {
    private StringTask stringTask;
    private String actualString;
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
}
