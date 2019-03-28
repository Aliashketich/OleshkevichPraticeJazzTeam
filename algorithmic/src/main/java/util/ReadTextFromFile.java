package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFromFile {
    private static StringBuilder stringFromText = new StringBuilder();

    public List<String> readText(String path) throws IOException {
        ArrayList<String> arr = new ArrayList<String>();
        try (FileReader fileReader = new FileReader(path); BufferedReader br = new BufferedReader(fileReader)) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
