package StringTask;

import org.apache.log4j.Logger;
import org.junit.*;

import java.io.IOException;


public class StringTaskTest {

    private static final Logger logger = Logger.getLogger(StringTaskTest.class);
    StringTask stringTask;
    String expectedString;

    @Before
    public void setUp() throws IOException {
        stringTask = new StringTask();
        expectedString = stringTask.transliteration();

    }

    @Test
    public void runTransliterationTest() throws Exception {
        logger.info("Имя теста: runTransliterationTest");
        String actual = "Praktika eto prekrasno!";
        Assert.assertEquals("Полученная строка не совпадает с тестовой", expectedString, actual);
    }

    @Test
    public void testStringIsNull() throws Exception {
        logger.info("Имя теста: testStringIsNull");
        Assert.assertNotNull("Полученная строка null", expectedString);
    }

    @Ignore("Test has been ignored.")
    @Test
    public void ignoredTest() {
        logger.info("will not print it");
    }

    @BeforeClass
    public static void beforeClass() {
        logger.info("Before StringTask.class");
    }

    @AfterClass
    public static void afterClass() {
        logger.info("After StringTask.class");
    }
}
