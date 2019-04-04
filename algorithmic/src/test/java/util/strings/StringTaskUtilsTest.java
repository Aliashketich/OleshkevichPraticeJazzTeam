package util.strings;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static util.strings.StringTaskUtils.*;

public class StringTaskUtilsTest {

    private HashMap<String, String> vocabularyForTest = new HashMap<>();
    private String[] expectedStringArray = new String[3];

    @Before
    public void setUp() {
        vocabularyForTest.put("we", "мы");
        vocabularyForTest.put("build", "строим");
        vocabularyForTest.put("house", "дом");
    }

    @Test
    public void translateWordToRussianTest() {
        assertEquals("строим", translateWordFromEnglishToRussian("build", vocabularyForTest));
    }

    @Test
    public void translateWordToRussianWordNotFoundInVocabularyTest() {
        assertEquals("", translateWordFromEnglishToRussian("dry", vocabularyForTest));
    }

    @Test
    public void splitStringWithSetRegexTest() {
        expectedStringArray[0] = "мы";
        expectedStringArray[1] = "строим";
        expectedStringArray[2] = "дом";
        assertArrayEquals(expectedStringArray, splitStringWithSetRegex("мы--!!строим- .дом"));
    }

    @Test
    public void splitStringWithSetRegexWithNotSetSeparatorTest() {
        expectedStringArray[0] = "мы";
        expectedStringArray[1] = "№№строим";
        expectedStringArray[2] = "дом";
        assertArrayEquals(expectedStringArray, splitStringWithSetRegex("мы--№№строим- .дом"));
    }

    @Test(expected = NullPointerException.class)
    public void saveStringInUnicodeFileIsNullTest() {
        String nullString = null;
        saveInUnicode(nullString);
    }

    @Test(expected = NullPointerException.class)
    public void saveStringFromStringBuilderInUnicodeFileIsNullTest() {
        StringBuilder nullString = null;
        saveInUnicode(nullString);
    }

}