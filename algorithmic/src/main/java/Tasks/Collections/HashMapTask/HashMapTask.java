package Tasks.Collections.HashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.MyExceptionForFileWork;

import java.io.IOException;
import java.util.HashMap;

import static util.fileUtil.GetVocabularyFromFile.setVocabularyToHashMap;
import static util.stringsUtil.TranslateWordToRussian.translateWordToRussian;

class HashMapTask {
    String translateStringToRussian(String filePath, String stringForTransliteration) throws IOException, MyExceptionForFileWork {
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
        } catch (MyExceptionForFileWork | IOException e) {
            throw e;
        }
        if (!stringAfterTransliteration.toString().equals(""))
            return stringAfterTransliteration.toString().substring(0, stringAfterTransliteration.toString().length() - 1);
        else return stringAfterTransliteration.toString();
    }
}
