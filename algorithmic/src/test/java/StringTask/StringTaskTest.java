package StringTask;

import exception.MyExceptionForGetStringFromFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;


public class StringTaskTest {

    private StringTask stringTask;
    private String expectedString;

    @Before
    public void setUp() {
        stringTask = new StringTask();
    }

    @Test
    public void transliterationResultTest() throws MyExceptionForGetStringFromFile, FileNotFoundException {
        String filePath = "src/main/java/StringTask/data.txt";
        expectedString = "Praktika eto prekrasno!";
        Assert.assertEquals("Strings not equals", expectedString, stringTask.transliteration(filePath));
    }

    @Test(expected = MyExceptionForGetStringFromFile.class)
    public void primaryTransliterationTestStringIsNull() throws FileNotFoundException, MyExceptionForGetStringFromFile {
        String filePath = "src/main/java/StringTask/data1.txt";
        Assert.assertEquals("Test file not found", stringTask.transliteration(filePath));
    }

    @Test(expected = MyExceptionForGetStringFromFile.class)
    public void transliterationTestFileIsEmpty() throws MyExceptionForGetStringFromFile, FileNotFoundException {
        String filePath = "src/main/java/StringTask/emptyTestFile.txt";
        Assert.assertEquals("Strings not equals", stringTask.transliteration(filePath));
    }

    @Test
    public void transliterationTestFileContainsOnlyNumbers() throws MyExceptionForGetStringFromFile, FileNotFoundException {
        String filePath = "src/main/java/StringTask/TestFileWithNumbers.txt";
        expectedString = "1234567890";
        Assert.assertEquals(expectedString, stringTask.transliteration(filePath));
    }

    @Test(expected = MyExceptionForGetStringFromFile.class)
    public void transliterationTestFileContainsLatinSymbols() throws MyExceptionForGetStringFromFile, FileNotFoundException {
        String filePath = "src/main/java/StringTask/TestFileWithLatinSymbols.txt";
        Assert.assertEquals("Test string have latin symbols", stringTask.transliteration(filePath));
    }
}
