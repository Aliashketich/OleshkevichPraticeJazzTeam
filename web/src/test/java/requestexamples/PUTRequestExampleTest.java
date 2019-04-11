package requestexamples;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static requestexamples.PUTRequestExample.executePUTRequest;

public class PUTRequestExampleTest {
    @Test
    public void executePUTRequestTest() throws IOException {
        assertEquals(200,executePUTRequest());
    }
}