package Tasks.Files.Task1;

import exception.FileWorkException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    public void squareBuildIsCorrect() {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/fileToCompareResult.txt";
//        Assert.assertEquals();
    }

    @Test(expected = FileWorkException.class)
    public void testFileIsEmpty() throws IOException, FileWorkException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/emptyTestFile.txt";
        Assert.assertEquals("Test file is empty!", fileTask.buildSquare(filePath));
    }

}