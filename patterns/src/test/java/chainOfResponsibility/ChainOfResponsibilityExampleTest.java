package chainOfResponsibility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainOfResponsibilityExampleTest {

    private static final String INFO = "это информация ";
    private static final String ERROR = "это ошибка ";
    private static final String DEBUG = "это отладка ";
    private Logger infoLogger = new InfoLogger(LoggerType.INFO);
    private Logger errorLogger = new ErrorLogger(LoggerType.ERROR);
    private Logger debugLogger = new DebugLogger(LoggerType.DEBUG);

    @Before
    public void setUp() {

        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);

        infoLogger.nextLogger(LoggerType.INFO, INFO);
        infoLogger.nextLogger(LoggerType.ERROR, ERROR);
        infoLogger.nextLogger(LoggerType.DEBUG, DEBUG);
    }


    @Test
    public void infoLoggerIsNotNullTest() {
        assertNotNull(infoLogger);
    }

    @Test
    public void errorLoggerIsNotNullTest() {
        assertNotNull(errorLogger);
    }

    @Test
    public void debugLoggerIsNotNullTest() {
        assertNotNull(debugLogger);
    }

    @Test
    public void infoLoggerWorkTest() {
        assertEquals(infoLogger.getMessageToLog(), "INFO это информация ");
        assertNotEquals(infoLogger.getMessageToLog(), "это информация ");
    }

    @Test
    public void errorLoggerWorkTest() {
        assertEquals(errorLogger.getMessageToLog(), "ERROR это информация ERROR это ошибка ");
        assertNotEquals(errorLogger.getMessageToLog(), "ERROR это ошибка ");
    }

    @Test
    public void debugLoggerWorkTest() {
        assertEquals(debugLogger.getMessageToLog(), "DEBUG это информация DEBUG это ошибка DEBUG это отладка ");
        assertNotEquals(debugLogger.getMessageToLog(), "DEBUG это отладка ");
    }
}