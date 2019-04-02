package util.file;

import exception.MyException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetTextFromFile {

    public static ArrayList<String> readAllStringsFromFile(String path) throws IOException, MyException {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        try (Scanner scanFile = new Scanner(new File(path))) {
            while (scanFile.hasNext()) {
                stringsFromFile.add(scanFile.next());
            }
        } catch (IOException e) {
            throw e;
        }
        if (!stringsFromFile.isEmpty())
            return stringsFromFile;
        else
            throw new MyException("Test file is empty!");
    }

    public static String readStringFromFile(String path) throws MyException, IOException {

        String stringFromFile = "";

        try (Scanner scanFile = new Scanner(new File(path))) {
            while (scanFile.hasNext()) {
                stringFromFile = scanFile.nextLine();
            }
        } catch (IOException e) {
            throw e;
        }
        String stringSaveInUnicode = new String(stringFromFile.getBytes(), StandardCharsets.UTF_8);
        if (!stringSaveInUnicode.equals("")) {
            return stringSaveInUnicode;
        } else
            throw new MyException("Test string must be not empty!");
    }
    public static HashMap<String, String> getVocabularyFromFile(String vocabularyFilePath) throws IOException, MyException {

        ArrayList<String> stringArrayListFromReadTextFromFile = GetTextFromFile.readAllStringsFromFile(vocabularyFilePath);
        HashMap<String, String> vocabularyHashMap = new HashMap<>();

        for (int i = 0; i < stringArrayListFromReadTextFromFile.size(); i++) {
            String[] stringOfVocabulary = stringArrayListFromReadTextFromFile.get(i).split("/");
            vocabularyHashMap.put(stringOfVocabulary[0], stringOfVocabulary[1]);
        }

        if (vocabularyHashMap.isEmpty())
            throw new MyException("Vocabulary file is empty!");
        else return vocabularyHashMap;
    }
}
