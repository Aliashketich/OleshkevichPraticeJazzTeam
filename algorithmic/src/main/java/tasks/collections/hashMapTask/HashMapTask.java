package tasks.collections.hashMapTask;

/*Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 на другой язык согласно заранее составленному словарю(словарь - отдельный файл в формате "draw/рисовать")*/

import exception.MyException;

import java.io.IOException;
import java.util.HashMap;

import static util.file.FileTaskUtils.getVocabularyFromFile;
import static util.strings.StringTaskUtils.*;

class HashMapTask {
    String translateStringFromEnglishToRussian(String filePath, String stringToTranslate) throws IOException, MyException {
        final String[] wordsOfStringToTranslate = splitStringWithSetRegex(stringToTranslate);
        final HashMap<String, String> vocabulary = getVocabularyFromFile(filePath);

        StringBuilder russianString = new StringBuilder();
        for (int i = 0; i < wordsOfStringToTranslate.length; i++) {
            String russianWord = translateWordFromEnglishToRussian(wordsOfStringToTranslate[i], vocabulary);
            if (!russianWord.equals(""))
                russianString.append(russianWord).append(" ");
            else russianString.append(wordsOfStringToTranslate[i]).append(" ");
        }

        final String stringSaveInUnicode = saveInUnicode(russianString);
        if (!stringSaveInUnicode.equals(""))
            return stringSaveInUnicode.substring(0, stringSaveInUnicode.length() - 1);
        else return stringSaveInUnicode;
    }
}
