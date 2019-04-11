package requestexamples;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static requestexamples.POSTRequestExample.executePOSTRequest;

public class POSTRequestExampleTest {
    @Test
    public void executePOSTRequestTest() throws IOException {
        assertEquals(201, executePOSTRequest());
    }
}