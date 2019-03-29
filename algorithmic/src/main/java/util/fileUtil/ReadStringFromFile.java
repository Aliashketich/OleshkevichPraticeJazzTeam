package util.fileUtil;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadStringFromFile {
    private static final Logger logger = Logger.getLogger(ReadStringFromFile.class);

    private static StringBuilder stringFromFile = new StringBuilder();

    public String readString(String path) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(path); InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
            int data = inputStreamReader.read();
            char content;
            while (data != -1) {
                content = (char) data;
                stringFromFile.append(content);
                data = inputStreamReader.read();
            }
        } catch (IOException ex) {
            logger.error(ex);
        }
        return stringFromFile.toString();
    }
}
