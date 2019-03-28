package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
    private static StringBuilder stringFromFile = new StringBuilder();

    public String readFile(String path) throws IOException {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
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
            if (fileInputStream != null)
                fileInputStream.close();
            if (inputStreamReader != null)
                inputStreamReader.close();
        }
        return stringFromFile.toString();
    }
}
