package Tasks.Collections.HashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.MyException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static util.fileUtil.GetVocabularyFromFile.setVocabularyToHashMap;
import static util.stringsUtil.TranslateWordToRussian.translateWordToRussian;

class HashMapTask {
    String translateStringToRussian(String filePath, String stringForTransliteration) throws IOException, MyException {
        StringBuilder stringAfterTransliteration = new StringBuilder();
        String[] wordsForTransliteration = stringForTransliteration.split(" ");
        HashMap<String, String> vocabularyHashMap;
        try {
            vocabularyHashMap = setVocabularyToHashMap(filePath);
            for (int i = 0; i < wordsForTransliteration.length; i++) {
                String russianWord = translateWordToRussian(wordsForTransliteration[i], vocabularyHashMap);
                if (!russianWord.equals(""))
                    stringAfterTransliteration.append(russianWord).append(" ");
                else stringAfterTransliteration.append(wordsForTransliteration[i]).append(" ");
            }
        } catch (IOException e) {
            throw e;
        }
        String formatForJenkinsTestString = new String(stringAfterTransliteration.toString().getBytes(), StandardCharsets.UTF_8);
        if (!formatForJenkinsTestString.equals(""))
            return formatForJenkinsTestString.substring(0, formatForJenkinsTestString.length() - 1);
        else return formatForJenkinsTestString;
    }
}
