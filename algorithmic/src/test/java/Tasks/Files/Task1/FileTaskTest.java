package Tasks.Files.Task1;

import exception.FileWorkException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.fileUtil.ReadTextFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileTaskTest {
    private FileTask fileTask;

    @Before
    public void setUp() {
        fileTask = new FileTask();
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws IOException, FileWorkException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/notExistFile.txt";
        fileTask.buildSquare(filePath);
    }

    @Ignore
    @Test
    public void squareBuildIsCorrect() throws IOException, FileWorkException {
        String dataFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/data.txt";
        String actualFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/fileToCompareResult.txt";
        ArrayList<String> actualSquare = ReadTextFromFile.readTextFromFile(actualFilePath);
        Assert.assertEquals(fileTask.buildSquare(dataFilePath), actualSquare);
    }

    @Test(expected = FileWorkException.class)
    public void testFileIsEmpty() throws IOException, FileWorkException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/emptyTestFile.txt";
        Assert.assertEquals("Test file is empty!", fileTask.buildSquare(filePath));
    }

}