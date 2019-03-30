package Tasks.Strings.Task1;

import exception.FileWorkException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class StringTaskTest {

    private StringTask stringTask;
    private String actualString;

    @Before
    public void setUp() {
        stringTask = new StringTask();
    }

    @Test
    public void transliterationResultTest() throws FileWorkException, IOException {
        String filePath = "src/main/java/Tasks/Strings/Task1/TextFilesSources/data.txt";
        actualString = "Praktika eto prekrasno!";
        Assert.assertEquals("Strings not equals", stringTask.transliteration(filePath), actualString);
    }

    @Test(expected = FileNotFoundException.class)
    public void primaryTransliterationTestStringIsNull() throws IOException, FileWorkException {
        String filePath = "src/main/java/Tasks/Strings/Task1/TextFilesSources/data1.txt";
        stringTask.transliteration(filePath);
    }

    @Test(expected = FileWorkException.class)
    public void transliterationTestFileIsEmpty() throws FileWorkException, IOException {
        String filePath = "src/main/java/Tasks/Strings/Task1/TextFilesSources/emptyTestFile.txt";
        Assert.assertEquals("Test string must be not empty!", stringTask.transliteration(filePath));
    }

    @Test
    public void transliterationTestFileContainsOnlyNumbers() throws FileWorkException, IOException {
        String filePath = "src/main/java/Tasks/Strings/Task1/TextFilesSources/TestFileWithNumbers.txt";
        actualString = "1234567890";
        Assert.assertEquals(actualString, stringTask.transliteration(filePath));
    }

    @Test(expected = FileWorkException.class)
    public void transliterationTestFileContainsLatinSymbols() throws FileWorkException, IOException {
        String filePath = "src/main/java/Tasks/Strings/Task1/TextFilesSources/TestFileWithLatinSymbols.txt";
        Assert.assertEquals("Test string have latin symbols", stringTask.transliteration(filePath));
    }
}
