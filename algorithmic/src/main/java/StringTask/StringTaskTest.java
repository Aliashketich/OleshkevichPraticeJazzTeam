package StringTask;

import org.junit.Test;

import static StringTask.StringTask.transliteration;

public class StringTaskTest {

    @Test
    public void test() throws Exception {
        String text = "Снегурочка, СНЕГОВИК, СНЕЖок, РоМаШкА";
        System.out.println(transliteration(text));
    }
}
