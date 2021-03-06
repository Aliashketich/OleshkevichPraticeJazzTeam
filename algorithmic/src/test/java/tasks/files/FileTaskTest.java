package tasks.files;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static util.file.FileTaskUtils.readAllStringsFromFile;

public class FileTaskTest {
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textfiles/tasks/filetasktextfiles/";
    private FileTask fileTask;

    @Before
    public void setUp() {
        fileTask = new FileTask();
    }

    @Test(expected = FileNotFoundException.class)
    public void textFileWithWordsNotFoundTest() throws IOException, MyException {
        fileTask.buildLargestRectangleOfWords(ROOT_FILE_DIRECTORY_PATH + "notExistFile.txt");
    }

    @Test
    public void rectangleOfWordsBuildingIsCorrectTest() throws IOException, MyException {
        assertEquals(readAllStringsFromFile(ROOT_FILE_DIRECTORY_PATH + "fileToCompareResult.txt"), fileTask.buildLargestRectangleOfWords(ROOT_FILE_DIRECTORY_PATH + "dataForTest.txt"));
    }

    @Test(expected = MyException.class)
    public void textFileWithWordsIsEmptyTest() throws IOException, MyException {
        assertEquals("Test file is empty!", fileTask.buildLargestRectangleOfWords(ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt"));
    }

    @Test(expected = MyException.class)
    public void rectangleCanNotBeBuildWithEntryValuesTest() throws IOException, MyException {
        assertEquals("Solution not found!", fileTask.buildLargestRectangleOfWords(ROOT_FILE_DIRECTORY_PATH + "testFileWithoutSolution.txt"));
    }

    @Test
    public void buildRectangleWithOptimizedEntryValuesNegativeTest() throws MyException {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("clone");
        arrayList.add("tomes");
        arrayList.add("knock");
        arrayList.add("black");
        arrayList.add("value");
        assertNull(fileTask.buildRectangleWithOptimizedEntryValues(5, arrayList, 0, 5, 5));
    }

}