package factory.ext;

import factory.AbstractWriter;

public class ConsoleWriter extends AbstractWriter {
    public String getNameOfConcreteWriter() {
        return "console";
    }
}