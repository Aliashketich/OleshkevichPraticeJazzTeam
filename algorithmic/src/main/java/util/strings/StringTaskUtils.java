package util.strings;

import java.util.HashMap;

public class StringTaskUtils {
    public static String translateWordToRussian(String englishWord, HashMap<String, String> vocabularyHashMap) {
        String russianWord = "";

        for (int i = 0; i < vocabularyHashMap.size(); i++) {
            if (!String.valueOf(vocabularyHashMap.get(englishWord)).equals("null")) {
                russianWord = vocabularyHashMap.get(englishWord);
                break;
            }
        }
        return russianWord;
    }
    public static String[] splitStringWithSetRegex(String string) {
        return string.split("[\\\\s\\\\-\\\\-\\\\.\\\\'\\\\@\\\\!\\\\?\\\\,\\\\_\\\\ ]+");
    }
}
