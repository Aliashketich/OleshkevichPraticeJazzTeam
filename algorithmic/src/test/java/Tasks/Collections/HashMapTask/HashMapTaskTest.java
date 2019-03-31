package Tasks.Collections.HashMapTask;

import exception.FileWorkException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HashMapTaskTest {
    private HashMapTask hashMapTask;
    private String stringForTransliteration;

    @Before
    public void setUp() {
        hashMapTask = new HashMapTask();
        stringForTransliteration = "we collect constructor";
    }

    @Test
    public void checkResultOfTransliteration() throws IOException, FileWorkException {
        String expectedString = "мы собираем конструктор";
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration));
    }

    @Test(expected = FileNotFoundException.class)
    public void vocabularyFileNotFoundExceptionProcessing() throws IOException, FileWorkException {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabularyNotExist.txt";
        hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration);
    }

    @Test
    public void someWordsIsNotInVocabularyTranslation() throws IOException, FileWorkException {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        String expectedString = "she собираем конструктор";
        String stringForTransliterationInThisTest = "she collect constructor";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliterationInThisTest));
    }

    @Test
    public void stringForTransliterationIsEmpty() throws IOException, FileWorkException {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        String expectedString = "";
        String stringForTransliterationInThisTest = "";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliterationInThisTest));
    }

    @Test(expected = FileWorkException.class)
    public void vocabularyFileIsEmpty() throws IOException, FileWorkException {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabularyIsEmpty.txt";
        Assert.assertEquals("Vocabulary file is empty!", hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration));
    }

}