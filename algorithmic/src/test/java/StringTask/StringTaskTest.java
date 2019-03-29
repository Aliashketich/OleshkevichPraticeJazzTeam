package StringTask;

import org.apache.log4j.Logger;
import org.junit.*;


public class StringTaskTest {

    private static final Logger logger = Logger.getLogger(StringTaskTest.class);
    private StringTask stringTask;
    private String recieveString;
    private String expectedString;

    @Before
    public void setUp() throws Exception {
        stringTask = new StringTask();
        recieveString = stringTask.transliteration();
        expectedString = new String(recieveString.getBytes("windows-1251"), "utf-8");
    }

    @Test
    public void runTransliterationTest() throws Exception {
        logger.info("Test name: runTransliterationTest");
        String actual = "Praktika eto prekrasno!";
        Assert.assertEquals("Strings not equals", expectedString, actual);
    }

    @Test
    public void testStringIsNull() throws Exception {
        logger.info("Test name: testStringIsNull");
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
