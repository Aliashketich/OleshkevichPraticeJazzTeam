package tasks.strings;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class StringTaskTest {
    private static final String ROOT_FILE_DIRECTORY_PATH = "src/main/resources/textfiles/tasks/stringtasktextfiles/stringtransliteration/";
    private StringTask stringTask;

    @Before
    public void setUp() {
        stringTask = new StringTask();
    }

    @Test
    public void transliterationResultTest() throws MyException, IOException {
        assertEquals("Praktika eto prekrasno!", stringTask.stringTransliterationFromRussianToEnglishSymbols(ROOT_FILE_DIRECTORY_PATH + "data.txt"));
    }

    @Test(expected = FileNotFoundException.class)
    public void fileWithStringForTransliterationIsNullTest() throws IOException, MyException {
        stringTask.stringTransliterationFromRussianToEnglishSymbols(ROOT_FILE_DIRECTORY_PATH + "data1.txt");
    }

    @Test(expected = MyException.class)
    public void transliterationFileIsEmptyTest() throws MyException, IOException {
        assertEquals("Test string must be not empty!", stringTask.stringTransliterationFromRussianToEnglishSymbols(ROOT_FILE_DIRECTORY_PATH + "emptyTestFile.txt"));
    }

    @Test
    public void fileWithStringForTransliterationContainsOnlyNumbersTest() throws MyException, IOException {
        assertEquals("1234567890", stringTask.stringTransliterationFromRussianToEnglishSymbols(ROOT_FILE_DIRECTORY_PATH + "testFileWithNumbers.txt"));
    }

    @Test(expected = MyException.class)
    public void fileWithStringForTransliterationContainsLatinSymbolsTest() throws MyException, IOException {
        assertEquals("Test string contains some latin symbols", stringTask.stringTransliterationFromRussianToEnglishSymbols(ROOT_FILE_DIRECTORY_PATH + "testFileWithLatinSymbols.txt"));
    }


    @Test
    public void selectIdenticalWordsFromTwoStringsResultTest() {
        assertEquals("лес хорошо", stringTask.selectIdenticalWordsFromTwoStrings("поле лес дом смородина хорошо", "снег скворец лес хорошо тепло"));
    }

    @Test
    public void selectIdenticalWordsFromStringsWhereOneStringHasSpecialSymbolsTest() {
        assertEquals("лес хорошо", stringTask.selectIdenticalWordsFromTwoStrings("поле лес дом\n смородина хорошо\n", "снег скворец\t лес хорошо\b тепло"));
    }

    @Test(expected = NullPointerException.class)
    public void oneOfEntryStringIsNullTest() {
        stringTask.selectIdenticalWordsFromTwoStrings(null, "снег скворец лес");
    }

    @Test(expected = NullPointerException.class)
    public void bothEntryStringsIsNullTest() {
        stringTask.selectIdenticalWordsFromTwoStrings(null, null);
    }

    @Test
    public void stringsHaveNotIdenticalWordsTest() {
        assertEquals("", stringTask.selectIdenticalWordsFromTwoStrings("поле дом смородина", "снег скворец лес хорошо тепло"));
    }

    @Test
    public void wordsInStringsAreDividedByNotSpaceOnlyTest() {
        assertEquals("утром не лесу", stringTask.selectIdenticalWordsFromTwoStrings("Ранним утром!хорошо прогуляться не только по лесу, но и вдоль реки.", "Прошлым-утром я не встретил его в лесу."));
    }

    @Test
    public void multipleEntryOfIdenticalWordToPrimaryStringTest() {
        assertEquals("утром не по лесу", stringTask.selectIdenticalWordsFromTwoStrings("Ранним утром!хорошо  прогуляться не только по по лесу, но и вдоль реки, и по полю.", "Прошлым-утром я не встретил его во по время прогулки по лесу."));
    }
}
