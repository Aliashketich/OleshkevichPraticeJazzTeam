package factory;

import exception.MyException;
import factory.ext.ConsoleWriter;
import factory.ext.FileWriter;

public class Factory {
    public static AbstractWriter getRequiredWriter(Object message) throws MyException {
        AbstractWriter requiredWriter;
        if (message instanceof String) {
            requiredWriter = new ConsoleWriter();
        } else if (message instanceof Integer) {
            requiredWriter = new FileWriter();
        } else throw new MyException("Recent Object have not eligible type.");
        return requiredWriter;
    }
}
