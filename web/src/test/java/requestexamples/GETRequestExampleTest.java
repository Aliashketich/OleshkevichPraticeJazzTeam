package requestexamples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GETRequestExampleTest {

    @Test
    public void getElementTitleFromGETRequestTest() {
        assertEquals("quidem molestiae enim", GETRequestExample.getStringFromGETRequest(1, "title"));
    }

}