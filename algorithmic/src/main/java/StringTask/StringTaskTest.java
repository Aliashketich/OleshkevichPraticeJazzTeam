package StringTask;

import org.junit.Test;

import static StringTask.StringTask.transliteration;

public class StringTaskTest {

    @Test
    public void test(){
        StringTask stringTask = new StringTask();
        String text = "Азбука, ЕЖиК, ТеРеМок";
        System.out.println(transliteration(text));
    }
}
