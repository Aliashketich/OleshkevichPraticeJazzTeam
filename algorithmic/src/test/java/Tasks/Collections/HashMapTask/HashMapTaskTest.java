package Tasks.Collections.HashMapTask;

import exception.MyExceptionForFileWork;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HashMapTaskTest {
    private HashMapTask hashMapTask;
    private String stringForTransliteration;

    @Before
    public void setUp() {
        hashMapTask = new HashMapTask();
        stringForTransliteration = "we collect constructor";
    }

    @Test
    public void checkResultOfTransliteration() throws IOException, MyExceptionForFileWork {
        String expectedString = "мы собираем конструктор";
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        String actualString = new String(hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration).getBytes(), StandardCharsets.UTF_8);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test(expected = FileNotFoundException.class)
    public void vocabularyFileNotFoundExceptionProcessing() throws IOException, MyExceptionForFileWork {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabularyNotExist.txt";
        hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration);
    }

    @Test
    public void someWordsIsNotInVocabularyTranslation() throws IOException, MyExceptionForFileWork {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        String expectedString = "she собираем конструктор";
        String stringForTransliterationInThisTest = "she collect constructor";
        String actualString = new String(hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliterationInThisTest).getBytes(), StandardCharsets.UTF_8);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void stringForTransliterationIsEmpty() throws IOException, MyExceptionForFileWork {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabulary.txt";
        String expectedString = "";
        String stringForTransliterationInThisTest = "";
        Assert.assertEquals(expectedString, hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliterationInThisTest));
    }

    @Test(expected = MyExceptionForFileWork.class)
    public void vocabularyFileIsEmpty() throws IOException, MyExceptionForFileWork {
        String vocabularyFilePath = "src/main/java/Tasks/Collections/HashMapTask/TextFileSources/vocabularyIsEmpty.txt";
        Assert.assertEquals("Vocabulary file is empty!", hashMapTask.translateStringToRussian(vocabularyFilePath, stringForTransliteration));
    }

}