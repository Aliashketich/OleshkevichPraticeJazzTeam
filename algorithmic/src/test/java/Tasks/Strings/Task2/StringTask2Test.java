package Tasks.Strings.Task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringTask2Test {
    private StringTask2 stringTask;
    private String firstString;
    private String secondString;
    private String actualString;

    @Before
    public void setUp() {
        stringTask = new StringTask2();
    }

    @Test
    public void printIdenticalWordsFromTwoStringsResultTest() {
        firstString = "поле лес дом смородина хорошо";
        secondString = "снег скворец лес хорошо тепло";
        actualString = "лес хорошо";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test(expected = NullPointerException.class)
    public void oneOfPrimaryStringIsNull() {
        firstString = null;
        secondString = "снег скворец лес";
        stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString);
    }

    @Test(expected = NullPointerException.class)
    public void bothPrimaryStringsIsNull() {
        firstString = null;
        secondString = null;
        stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString);
    }

    @Test
    public void stringsHaveNotIdenticalWords() {
        firstString = "поле дом смородина";
        secondString = "снег скворец лес хорошо тепло";
        actualString = "";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test
    public void wordsInStringsAreDividedByNotSpaceOnly(){
        firstString = "Ранним утром!хорошо прогуляться не только по лесу, но и вдоль реки.";
        secondString = "Прошлым-утром я не встретил его в лесу.";
        actualString = "утром не лесу";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }

    @Test
    public void multipleEntryOfIdenticalWord(){
        firstString = "Ранним утром!хорошо  прогуляться не только по по лесу, но и вдоль реки, и по полю.";
        secondString = "Прошлым-утром я не встретил его во по время прогулки по лесу.";
        actualString = "утром не по лесу";
        Assert.assertEquals(stringTask.printIdenticalWordsFromTwoStrings(firstString, secondString), actualString);
    }
}