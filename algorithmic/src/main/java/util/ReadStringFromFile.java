package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadStringFromFile {
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
            ex.printStackTrace();
        }
        return stringFromFile.toString();
    }
}
