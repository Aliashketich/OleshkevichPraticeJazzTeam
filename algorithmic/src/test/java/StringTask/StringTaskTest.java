package StringTask;

import org.apache.log4j.Logger;
import org.junit.*;


public class StringTaskTest {

    private static final Logger logger = Logger.getLogger(StringTaskTest.class);
    StringTask stringTask = new StringTask();

    @BeforeClass
    public static void beforeClass() {
        logger.info("Before StringTask.class");
    }

    @AfterClass
    public static void afterClass() {
        logger.info("After StringTask.class");
    }

    @Test
    public void runTransliterationTest() throws Exception {
        logger.info("Имя теста: runTransliterationTest");
        String actual = "Praktika eto prekrasno!";
        Assert.assertEquals("Полученная строка не совпадает с тестовой", stringTask.transliteration(), actual);
    }

    @Test
    public void testStringIsNull() throws Exception {
        logger.info("Имя теста: testStringIsNull");
        Assert.assertNotNull("Полученная строка null", stringTask.transliteration());
    }

    @Ignore("Test has been ignored.")
    @Test
    public void ignoredTest() {
        logger.info("will not print it");
    }

}
