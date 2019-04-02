package util.fileUtil;

import exception.MyException;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GetStringFromFile {
    private static final Logger logger = Logger.getLogger(GetStringFromFile.class);


    public static String readString(String path) throws MyException, IOException {

        StringBuilder stringFromFile = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(path); InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {

            int data = inputStreamReader.read();
            char content;
            while (data != -1) {
                content = (char) data;
                stringFromFile.append(content);
                data = inputStreamReader.read();
            }
            if (!stringFromFile.toString().equals("")) {
                return stringFromFile.toString();
            } else
                throw new MyException("Test string must be not empty!");

        } catch (FileNotFoundException | NullPointerException ex) {
            throw ex;
        }
    }
}
