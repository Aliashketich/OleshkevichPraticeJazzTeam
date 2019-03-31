package Tasks.Collections.HashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.FileWorkException;
import util.fileUtil.ReadTextFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTask {
    public String translateStringToRussian(String filePath, String stringForTransliteration) throws IOException, FileWorkException {
        StringBuilder stringAfterTransliteration = new StringBuilder();
        String[] wordsForTransliteration = stringForTransliteration.split(" ");
        HashMap<String, String> vocabularyHashMap;
        try {
            vocabularyHashMap = setVocabularyToHashMap(filePath);
            for (int i = 0; i < wordsForTransliteration.length; i++) {
                String russianWord = translateWord(wordsForTransliteration[i], vocabularyHashMap);
                if (!russianWord.equals(""))
                    stringAfterTransliteration.append(russianWord).append(" ");
                else stringAfterTransliteration.append(wordsForTransliteration[i]).append(" ");
            }
        } catch (FileWorkException | IOException e) {
            throw e;
        }
        if (!stringAfterTransliteration.toString().equals(""))
            return stringAfterTransliteration.toString().substring(0, stringAfterTransliteration.toString().length() - 1);
        else return stringAfterTransliteration.toString();
    }

    private String translateWord(String englishWord, HashMap<String, String> vocabularyHashMap) {
        String russianWord = "";

        for (int i = 0; i < vocabularyHashMap.size(); i++) {
            if (!String.valueOf(vocabularyHashMap.get(englishWord)).equals("null")) {
                russianWord = vocabularyHashMap.get(englishWord);
                break;
            }
        }
        if (russianWord.equals(""))
            return "";
        else
            return russianWord;
    }

    public HashMap<String, String> setVocabularyToHashMap(String filePath) throws IOException, FileWorkException {
        ArrayList<String> stringArrayListFromReadTextFromFile = ReadTextFromFile.readTextFromFile(filePath);
        HashMap<String, String> vocabularyToHashMap = new HashMap<>();
        for (int i = 0; i < stringArrayListFromReadTextFromFile.size(); i++) {
            String[] stringOfVocabulary = stringArrayListFromReadTextFromFile.get(i).split("/");
            vocabularyToHashMap.put(stringOfVocabulary[0], stringOfVocabulary[1]);
        }
        if (vocabularyToHashMap.isEmpty())
            throw new FileWorkException("Vocabulary file is empty!");
        else return vocabularyToHashMap;
    }

}
