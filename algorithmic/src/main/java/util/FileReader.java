package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
    private static StringBuilder str = new StringBuilder();

    public String readFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
        try {
            int data = inputStreamReader.read();
            char content;
            while (data != -1) {
                content = (char) data;
                str.append(content);
                data = inputStreamReader.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            fileInputStream.close();
        }
        return str.toString();
    }
}
