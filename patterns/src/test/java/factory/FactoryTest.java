package factory;

import exception.MyException;
import org.junit.Test;

import static factory.Factory.getRequiredWriter;
import static org.junit.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void consoleWriterSelectionTest() throws MyException {
        assertEquals("console", getRequiredWriter("consoleWriter").getNameOfConcreteWriter());
    }

    @Test
    public void fileWriterSelectionTest() throws MyException {
        assertEquals("file", getRequiredWriter(228).getNameOfConcreteWriter());
    }

    @Test(expected = MyException.class)
    public void nonexistentWriterSelectionTest() throws MyException {
        getRequiredWriter('c');
    }

    @Test(expected = MyException.class)
    public void nullWriterSelectionTest() throws MyException {
        getRequiredWriter(null);
    }
}