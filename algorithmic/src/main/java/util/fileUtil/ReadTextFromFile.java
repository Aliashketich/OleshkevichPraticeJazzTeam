package util.fileUtil;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFromFile {
    private static final Logger logger = Logger.getLogger(ReadTextFromFile.class);

    private static StringBuilder stringFromText = new StringBuilder();

    public static List<String> readText(String path) {
        ArrayList<String> arr = new ArrayList<String>();
        try (FileReader fileReader = new FileReader(path); BufferedReader br = new BufferedReader(fileReader)) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return arr;
    }
}
