package tasks.collections.hashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.MyException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static util.file.FileTaskUtils.getVocabularyFromFile;
import static util.strings.StringTaskUtils.splitStringWithSetRegex;
import static util.strings.StringTaskUtils.translateWordFromEnglishToRussian;

class HashMapTask {
    String translateStringFromEnglishToRussian(String filePath, String stringToTranslate) throws IOException, MyException {
        StringBuilder russianString = new StringBuilder();
        String[] wordsOfStringToTranslate = splitStringWithSetRegex(stringToTranslate);
        HashMap<String, String> vocabulary;

        vocabulary = getVocabularyFromFile(filePath);
        for (int i = 0; i < wordsOfStringToTranslate.length; i++) {
            String russianWord = translateWordFromEnglishToRussian(wordsOfStringToTranslate[i], vocabulary);
            if (!russianWord.equals(""))
                russianString.append(russianWord).append(" ");
            else russianString.append(wordsOfStringToTranslate[i]).append(" ");
        }

        // TODO: 04.04.2019 Сделать метод для сохранения строки в Unicode UTF-8
        String stringSaveInUnicode = new String(russianString.toString().getBytes(), StandardCharsets.UTF_8);
        if (!stringSaveInUnicode.equals(""))
            return stringSaveInUnicode.substring(0, stringSaveInUnicode.length() - 1);
        else return stringSaveInUnicode;
    }
}
