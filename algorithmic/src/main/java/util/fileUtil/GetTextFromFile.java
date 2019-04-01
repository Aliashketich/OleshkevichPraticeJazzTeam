package util.fileUtil;

import exception.MyExceptionForFileWork;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetTextFromFile {
    private static final Logger logger = Logger.getLogger(GetTextFromFile.class);

    public static ArrayList<String> readFile(String path) throws IOException, MyExceptionForFileWork {
        ArrayList<String> stringsFromFile = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringsFromFile.add(currentLine);
            }
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
        if (!stringsFromFile.isEmpty())
            return stringsFromFile;
        else
            throw new MyExceptionForFileWork("Test file is empty!");
    }
}
