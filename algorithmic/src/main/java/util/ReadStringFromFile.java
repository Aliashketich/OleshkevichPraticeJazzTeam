package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadStringFromFile {
    private static StringBuilder stringFromFile = new StringBuilder();

    public String readString(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
        try {
            fileInputStream = new FileInputStream(path);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            int data = inputStreamReader.read();
            char content;
            while (data != -1) {
                content = (char) data;
                stringFromFile.append(content);
                data = inputStreamReader.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            fileInputStream.close();
            inputStreamReader.close();
        }
        return stringFromFile.toString();
    }
}
