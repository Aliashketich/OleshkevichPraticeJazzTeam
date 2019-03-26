package StringTask;

import org.junit.*;

import static StringTask.StringTask.letters;
import static StringTask.StringTask.transliteration;

public class StringTaskTest {

    private static String text = "Подъезд, Снеговик, ПАНОРАМА";

    private StringTask stringTask;
    @Test
    public void runTransliterationTest() throws Exception {
        System.out.println(transliteration(text));
    }

    @Test
    public void incorrectSymbolsInPrimaryString(){
        byte[] textBytes = text.getBytes();
        for (int i=0;i<text.length();i++){
            String temp = String.valueOf(textBytes[i]);
            if(letters.get(temp)==null){
                System.out.println("\nPrimary String has incorrect symbols (latin / numbers / !@#$%^&*()_+-=\n");
                i=text.length()+1;
            }
        }
    }

    @Test
    public void nullStringTest(){
        if (text==null){
            System.out.println("Primary string is null!");
        }
    }

    @Test
    public void nullReturnValue(){
        if(transliteration(text)==null){
            System.out.println("Return value is null!");
        }
    }

    @Ignore("Test has been ignored.")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before StringTask.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After StringTask.class");
    }

    @Before
    public void initTest() {
        stringTask = new StringTask();
    }

    @After
    public void afterTest() {
        stringTask = null;
    }
}
