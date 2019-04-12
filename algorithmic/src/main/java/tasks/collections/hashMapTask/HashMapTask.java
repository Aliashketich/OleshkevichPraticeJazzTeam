package tasks.collections.hashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.MyException;

import java.io.IOException;
import java.util.HashMap;

import static util.file.FileTaskUtils.getVocabularyFromFile;
import static util.strings.StringTaskUtils.*;

public class HashMapTask {
    public String translateStringFromEnglishToRussian(String filePath, String stringToTranslate) throws IOException, MyException {
        final String[] wordsOfStringToTranslate = splitStringWithSetRegex(stringToTranslate);
        final HashMap<String, String> vocabulary = getVocabularyFromFile(filePath);

        StringBuilder russianString = new StringBuilder();
        for (String wordFromStringToTranslate : wordsOfStringToTranslate) {
            String russianWord = translateWordFromEnglishToRussian(wordFromStringToTranslate, vocabulary);
            if (!russianWord.equals(""))
                russianString.append(russianWord).append(" ");
            else russianString.append(wordFromStringToTranslate).append(" ");
        }
        return saveInUnicode(russianString).substring(0, saveInUnicode(russianString).length() - 1);
    }
}
