package Tasks.Files.Task1;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
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
    public void testFileNotFound() throws IOException, MyException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/notExistFile.txt";
        fileTask.buildSquare(filePath);
    }

    @Test
    public void squareBuildIsCorrect() throws IOException, MyException {
        String dataFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/dataForTest.txt";
        String actualFilePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/fileToCompareResult.txt";
        ArrayList<String> expectedRectangle = GetTextFromFile.readFile(actualFilePath);
        Assert.assertEquals(expectedRectangle,fileTask.buildSquare(dataFilePath));
    }

    @Test(expected = MyException.class)
    public void testFileIsEmpty() throws IOException, MyException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/emptyTestFile.txt";
        Assert.assertEquals("Test file is empty!", fileTask.buildSquare(filePath));
    }

    @Test(expected = MyException.class)
    public void rectangleCanNotBeBuildWithEntryValuesTest() throws IOException, MyException {
        String filePath = "src/main/java/Tasks/Files/Task1/TextFilesSources/testFileWithoutSolution.txt";
        Assert.assertEquals("Solution not found!", fileTask.buildSquare(filePath));
    }
}