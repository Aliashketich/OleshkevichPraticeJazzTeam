package util.fileUtil;

import exception.FileWorkException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTextFromFile {
    private static final Logger logger = Logger.getLogger(ReadTextFromFile.class);


    public static ArrayList<String> readTextFromFile(String path) throws IOException, FileWorkException {
        ArrayList<String> stringsFromFile = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                stringsFromFile.add(sCurrentLine);
            }
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
        if (stringsFromFile.size() != 0)
            return stringsFromFile;
        else
            throw new FileWorkException("Test file is empty!");
    }
}
