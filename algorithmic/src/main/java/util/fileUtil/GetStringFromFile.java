package util.fileUtil;

import exception.MyExceptionForGetStringFromFile;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GetStringFromFile {
    private static final Logger logger = Logger.getLogger(GetStringFromFile.class);


    public static String readString(String path) throws MyExceptionForGetStringFromFile {
        FileInputStream fileInputStream;
        StringBuilder stringFromFile = new StringBuilder();

        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            throw new MyExceptionForGetStringFromFile("Test file not found");
        }

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        } catch (StringIndexOutOfBoundsException ex) {
            logger.error(ex);
        }

        if (inputStreamReader != null) {
            try {
                int data = inputStreamReader.read();
                char content;
                while (data != -1) {
                    content = (char) data;
                    stringFromFile.append(content);
                    data = inputStreamReader.read();
                }
            } catch (Exception ex) {
                logger.error(ex);
            } finally {
                try {
                    fileInputStream.close();
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
            if (stringFromFile.toString().equals("")) {
                throw new MyExceptionForGetStringFromFile("String can not be empty!");
            } else
                return stringFromFile.toString();
        } else
            throw new MyExceptionForGetStringFromFile("inputStreamReader is null");
    }
}
