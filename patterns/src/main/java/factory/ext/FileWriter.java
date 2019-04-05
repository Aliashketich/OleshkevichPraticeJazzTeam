package factory.ext;

import factory.AbstractWriter;

public class FileWriter extends AbstractWriter {
    public String getNameOfConcreteWriter() {
        return "file";
    }
}
