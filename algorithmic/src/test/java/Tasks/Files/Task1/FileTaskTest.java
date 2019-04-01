package Tasks.Files.Task1;

import exception.MyExceptionForFileWork;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.fileUtil.GetTextFromFile;

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
    public void testFileNotFound() throws IOException, MyExceptionForFileWork {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/notExistFile.txt";
        fileTask.buildSquare(filePath);
    }

    @Ignore
    @Test
    public void squareBuildIsCorrect() throws IOException, MyExceptionForFileWork {
        String dataFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/data.txt";
        String actualFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/fileToCompareResult.txt";
        ArrayList<String> actualSquare = GetTextFromFile.readFile(actualFilePath);
        Assert.assertEquals(fileTask.buildSquare(dataFilePath), actualSquare);
    }

    @Test(expected = MyExceptionForFileWork.class)
    public void testFileIsEmpty() throws IOException, MyExceptionForFileWork {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/emptyTestFile.txt";
        Assert.assertEquals("Test file is empty!", fileTask.buildSquare(filePath));
    }

}