package FileTask;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileTaskTest {
    private static final Logger logger = Logger.getLogger(FileTaskTest.class);
    FileTask fileTask;
    String checkString;

    @Before
    public void setUp() throws IOException {
        fileTask = new FileTask();
        checkString=fileTask.buildSquare();
    }

    @Test
    public void runFileTaskTest() throws Exception {
        logger.info("Имя теста: runFileTaskTest");
    }

    @Test
    public void fileIsEmpty(){
        logger.info("Имя теста: fileIsEmpty");
        Assert.assertNotNull(checkString);
    }

}