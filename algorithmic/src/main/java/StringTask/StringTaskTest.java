package StringTask;

import org.junit.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import static StringTask.StringTask.letters;
import static StringTask.StringTask.transliteration;


public class StringTaskTest {

    private static StringBuilder str = new StringBuilder();
    private static String text = str.toString();

    private StringTask stringTask;
    @Test
    public void runTransliterationTest() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/StringTask/data.txt");
        final InputStreamReader inputStreamReader  = new InputStreamReader(fileInputStream, "utf-8");
        int data = inputStreamReader.read();
        char content;
        while (data!=-1){
            content = (char) data;
            str.append(content);
            data = inputStreamReader.read();
        }
        fileInputStream.close();
        System.out.println(transliteration(str.toString()));
    }

    @Test
    public void incorrectSymbolsInPrimaryString(){
        byte[] textBytes = text.getBytes();
        for (int i=0;i<text.length();i++){
            String temp = String.valueOf(textBytes[i]);
            if(letters.get(temp)==null){
//                System.out.println("\nPrimary String has incorrect symbols (latin / numbers / !@#$%^&*()_+-=\n");
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
