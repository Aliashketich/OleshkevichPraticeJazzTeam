package tasks.collections.hashMapTask;

import exception.MyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HashMapTaskTest {
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textfiles/tasks/collectiontasktextfiles/hashmap/";
    private static final String VOCABULARY_PATH = "src/main/resources/textfiles/tasks/collectiontasktextfiles/hashmap/vocabulary.txt";
    private HashMapTask hashMapTask;
    private String stringForTransliteration;

    @Before
    public void setUp() {
        hashMapTask = new HashMapTask();
        stringForTransliteration = "we collect constructor";
    }

    //упал тест на jenkins, после переноса в expected строки в русских символах
    @Test
    public void checkResultOfTranslationTest() throws IOException, MyException {
        String correctTranslateString = "мы собираем конструктор";
        Assert.assertEquals(correctTranslateString, hashMapTask.translateStringFromEnglishToRussian(VOCABULARY_PATH, stringForTransliteration));
    }

    @Test(expected = FileNotFoundException.class)
    public void vocabularyFileNotFoundTest() throws IOException, MyException {
        String vocabularyFilePath = ROOT_FILE_DIRECTORY_PATH + "vocabularyNotExist.txt";
        hashMapTask.translateStringFromEnglishToRussian(vocabularyFilePath, stringForTransliteration);
    }

    //упал тест на jenkins, после переноса в expected строки в русских символах
    @Test
    public void someWordsIsNotInVocabularyTranslationResultTest() throws IOException, MyException {
        String stringWithWordThatIsNotInVocabulary = "she collect constructor";
        String correctTranslateString = "she собираем конструктор";
        Assert.assertEquals(correctTranslateString, hashMapTask.translateStringFromEnglishToRussian(VOCABULARY_PATH, stringWithWordThatIsNotInVocabulary));
    }

    @Test
    public void stringForTranslationIsEmptyTest() throws IOException, MyException {
        Assert.assertEquals("", hashMapTask.translateStringFromEnglishToRussian(VOCABULARY_PATH, ""));
    }

    @Test(expected = MyException.class)
    public void vocabularyFileIsEmptyTest() throws IOException, MyException {
        String vocabularyFilePath = ROOT_FILE_DIRECTORY_PATH + "vocabularyIsEmpty.txt";
        Assert.assertEquals("Vocabulary file is empty!", hashMapTask.translateStringFromEnglishToRussian(vocabularyFilePath, stringForTransliteration));
    }

}