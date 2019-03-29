package FileTask;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileTaskTest {
    private static final Logger logger = Logger.getLogger(FileTaskTest.class);
    FileTask fileTask;
    String checkString;

    @Before
    public void setUp() {
        fileTask = new FileTask();
        checkString = fileTask.buildSquare();
    }

    @Test
    public void runFileTaskTest() {
        logger.info("Test name: runFileTaskTest");
    }

    @Test
    public void fileIsEmpty() {
        logger.info("Test name: fileIsEmpty");
        Assert.assertNotNull(checkString);
    }

}