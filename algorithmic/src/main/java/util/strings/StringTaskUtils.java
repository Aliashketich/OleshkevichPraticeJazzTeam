package util.strings;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class StringTaskUtils {
    public static String translateWordFromEnglishToRussian(String englishWord, HashMap<String, String> vocabularyHashMap) {
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
        return string.split("[\\\\+\\\\-\\\\-\\\\.\\\\'\\\\@\\\\!\\\\?\\\\,\\\\_\\\\\n\\\\\t\\\\\f\\\\\r\\\\\b ]+");
    }

    public static String saveInUnicode(StringBuilder russianString) {
        return new String(russianString.toString().getBytes(), StandardCharsets.UTF_8);
    }

    public static String saveInUnicode(String russianString) {
        return new String(russianString.getBytes(), StandardCharsets.UTF_8);
    }

    public static boolean isWordAlreadySelect(String[] wordsArrayWithPossibleDuplication, String wordFromSecondString) {
        for (String wordFromArrayWithPossibleDuplication : wordsArrayWithPossibleDuplication) {
            if (wordFromArrayWithPossibleDuplication.equals(wordFromSecondString)) {
                return true;
            }
        }
        return false;
    }

}
