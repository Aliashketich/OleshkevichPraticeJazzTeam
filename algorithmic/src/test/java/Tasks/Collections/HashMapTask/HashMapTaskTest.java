package Tasks.Collections.HashMapTask;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HashMapTaskTest {
    private HashMapTask hashMapTask;
    private String stringForTransliteration;
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textFiles/tasks/collectionTaskTextFiles/hashMap/";
    private static final String VOCABULARY_PATH = "src/main/resources/textFiles/tasks/collectionTaskTextFiles/hashMap/vocabulary.txt";

    @Before
    public void setUp() {
        hashMapTask = new HashMapTask();
        stringForTransliteration = "we collect constructor";
    }

    @Test
    public void checkResultOfTransliteration() throws IOException, MyException {
        String expectedString = "мы собираем конструктор";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(VOCABULARY_PATH, stringForTransliteration));
    }

    @Test(expected = FileNotFoundException.class)
    public void vocabularyFileNotFoundExceptionProcessing() throws IOException, MyException {
        String vocabularyFilePath = ROOT_FILE_DIRECTORY_PATH + "vocabularyNotExist.txt";
        hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration);
    }

    @Test
    public void someWordsIsNotInVocabularyTranslation() throws IOException, MyException {
        String expectedString = "she собираем конструктор";
        String stringForTransliterationInThisTest = "she collect constructor";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(VOCABULARY_PATH, stringForTransliterationInThisTest));
    }

    @Test
    public void stringForTransliterationIsEmpty() throws IOException, MyException {
        String expectedString = "";
        String stringForTransliterationInThisTest = "";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(VOCABULARY_PATH, stringForTransliterationInThisTest));
    }

    @Test(expected = MyException.class)
    public void vocabularyFileIsEmpty() throws IOException, MyException {
        String vocabularyFilePath = ROOT_FILE_DIRECTORY_PATH + "vocabularyIsEmpty.txt";
        Assert.assertEquals("Vocabulary file is empty!", hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration));
    }

}