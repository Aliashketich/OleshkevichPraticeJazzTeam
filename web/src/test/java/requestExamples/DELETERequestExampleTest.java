package requestExamples;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static requestExamples.DELETERequestExample.executeDELETERequest;

public class DELETERequestExampleTest {
    @Test
    public void executeDELETERequestTest() throws IOException {
        assertEquals(200,executeDELETERequest());
    }

}