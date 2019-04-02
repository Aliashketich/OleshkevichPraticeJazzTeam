package util.file;

import exception.MyException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetTextFromFile {
    private static final Logger logger = Logger.getLogger(GetTextFromFile.class);

    public static ArrayList<String> readFile(String path) throws IOException, MyException {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        try (Scanner scanFile = new Scanner(new File(path))) {
            while (scanFile.hasNext()) {
                stringsFromFile.add(scanFile.next());
            }
        } catch (IOException e) {
            throw e;
        }
        if (!stringsFromFile.isEmpty())
            return stringsFromFile;
        else
            throw new MyException("Test file is empty!");
    }
}
