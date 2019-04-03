package tasks.files;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;
import util.file.GetTextFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileTaskTest {
    private FileTask fileTask;
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textFiles/tasks/fileTaskTextFiles/";

    @Before
    public void setUp() {
        fileTask = new FileTask();
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws IOException, MyException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "notExistFile.txt";
        fileTask.buildSquare(filePath);
    }

    @Test
    public void squareBuildIsCorrect() throws IOException, MyException {
        String dataFilePath = ROOT_FILE_DIRECTORY_PATH + "dataForTest.txt";
        String expectedFilePath = ROOT_FILE_DIRECTORY_PATH + "fileToCompareResult.txt";
        ArrayList<String> expectedRectangle = GetTextFromFile.readAllStringsFromFile(expectedFilePath);
        assertEquals(expectedRectangle, fileTask.buildSquare(dataFilePath));
    }

    @Test(expected = MyException.class)
    public void testFileIsEmpty() throws IOException, MyException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt";
        assertEquals("Test file is empty!", fileTask.buildSquare(filePath));
    }

    @Test(expected = MyException.class)
    public void rectangleCanNotBeBuildWithEntryValuesTest() throws IOException, MyException {
        String filePath = ROOT_FILE_DIRECTORY_PATH + "testFileWithoutSolution.txt";
        assertEquals("Solution not found!", fileTask.buildSquare(filePath));
    }
}