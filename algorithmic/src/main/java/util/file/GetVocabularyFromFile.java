package util.file;

import exception.MyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetVocabularyFromFile {

    public static HashMap<String, String> setVocabularyToHashMap(String vocabularyFilePath) throws IOException, MyException {

        ArrayList<String> stringArrayListFromReadTextFromFile = GetTextFromFile.readFile(vocabularyFilePath);
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
