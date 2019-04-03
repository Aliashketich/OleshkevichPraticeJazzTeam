package util.file;

import exception.MyException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetTextFromFileTest {

    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textFiles/filesForUtil/filesForFileWorkUtils/";

    @Test(expected = FileNotFoundException.class)
    public void readAllStringsFromFileFileNotFoundTest() throws IOException, MyException {
        String fileNotExistPath = "src/data.txt";
        GetTextFromFile.readAllStringsFromFile(fileNotExistPath);
    }

    @Test(expected = MyException.class)
    public void readAllStringsFromFileFileIsEmptyTest() throws IOException, MyException {
        String emptyFilePath = ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt";
        assertEquals("Test file is empty!", GetTextFromFile.readAllStringsFromFile(emptyFilePath).toString());
    }

    @Test
    public void readAllStringsFromFileWithEmptyFirstStringTest() throws IOException, MyException {
        String fileWithEmptyFirstStringPath = ROOT_FILE_DIRECTORY_PATH + "fileWithEmptyFirstString.txt";
        ArrayList<String> arrayListForTestWithEmptyFirstString = new ArrayList<>();
        arrayListForTestWithEmptyFirstString.add(0, "Two");
        arrayListForTestWithEmptyFirstString.add(1, "Three");
        assertEquals(arrayListForTestWithEmptyFirstString, GetTextFromFile.readAllStringsFromFile(fileWithEmptyFirstStringPath));
    }

    @Test(expected = FileNotFoundException.class)
    public void readStringFromFileFileNotFoundTest() throws IOException, MyException {
        String fileNotExistPath = "src/data.txt";
        GetTextFromFile.readStringFromFile(fileNotExistPath);
    }

    @Test(expected = MyException.class)
    public void readStringFromFileFileIsEmptyTest() throws IOException, MyException {
        String emptyFilePath = ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt";
        assertEquals("Test string must be not empty!", GetTextFromFile.readStringFromFile(emptyFilePath));
    }

    @Test
    public void readStringFromFileFileContainsSymbolsAndNumbersInStringTest() throws IOException, MyException {
        String emptyFilePath = ROOT_FILE_DIRECTORY_PATH + "fileWithSymbolsAndNumbers.txt";
        assertEquals("2314@#$1234$#$qwere##4411-0", GetTextFromFile.readStringFromFile(emptyFilePath));

    }

    @Test(expected = FileNotFoundException.class)
    public void getVocabularyFromFileFileNotFoundTest() throws IOException, MyException {
        String fileNotExistPath = "src/data.txt";
        GetTextFromFile.getVocabularyFromFile(fileNotExistPath);
    }

    @Test(expected = MyException.class)
    public void getVocabularyFromFileFileIsEmptyTest() throws IOException, MyException {
        String emptyFilePath = ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt";
        assertEquals("Vocabulary file is empty!", GetTextFromFile.getVocabularyFromFile(emptyFilePath).toString());
    }

}