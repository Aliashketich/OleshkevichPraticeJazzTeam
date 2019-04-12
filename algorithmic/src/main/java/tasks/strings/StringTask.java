package tasks.strings;

import exception.MyException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static util.file.FileTaskUtils.readStringFromFile;
import static util.strings.StringTaskUtils.isWordAlreadySelect;
import static util.strings.StringTaskUtils.splitStringWithSetRegex;

public class StringTask {
    private final Map<String, String> letters = new HashMap<>();

    {
        letters.put("А", "A");
        letters.put("Б", "B");
        letters.put("В", "V");
        letters.put("Г", "G");
        letters.put("Д", "D");
        letters.put("Е", "E");
        letters.put("Ё", "E");
        letters.put("Ж", "Zh");
        letters.put("З", "Z");
        letters.put("И", "I");
        letters.put("Й", "I");
        letters.put("К", "K");
        letters.put("Л", "L");
        letters.put("М", "M");
        letters.put("Н", "N");
        letters.put("О", "O");
        letters.put("П", "P");
        letters.put("Р", "R");
        letters.put("С", "S");
        letters.put("Т", "T");
        letters.put("У", "U");
        letters.put("Ф", "F");
        letters.put("Х", "Kh");
        letters.put("Ц", "C");
        letters.put("Ч", "Ch");
        letters.put("Ш", "Sh");
        letters.put("Щ", "Sch");
        letters.put("Ы", "Y");
        letters.put("Ъ", "'");
        letters.put("Э", "E");
        letters.put("Ю", "Yu");
        letters.put("Я", "Ya");
        letters.put("а", "a");
        letters.put("б", "b");
        letters.put("в", "v");
        letters.put("г", "g");
        letters.put("д", "d");
        letters.put("е", "e");
        letters.put("ё", "e");
        letters.put("ж", "zh");
        letters.put("з", "z");
        letters.put("и", "i");
        letters.put("й", "i");
        letters.put("к", "k");
        letters.put("л", "l");
        letters.put("м", "m");
        letters.put("н", "n");
        letters.put("о", "o");
        letters.put("п", "p");
        letters.put("р", "r");
        letters.put("с", "s");
        letters.put("т", "t");
        letters.put("у", "u");
        letters.put("ф", "f");
        letters.put("х", "h");
        letters.put("ц", "c");
        letters.put("ч", "ch");
        letters.put("ш", "sh");
        letters.put("щ", "sch");
        letters.put("ы", "y");
        letters.put("ъ", "'");
        letters.put("э", "e");
        letters.put("ю", "yu");
        letters.put("я", "ya");
        letters.put(",", ",");
        letters.put(".", ".");
        letters.put(" ", " ");
        letters.put("!", "!");
        letters.put("@", "@");
        letters.put("#", "#");
        letters.put("$", "$");
        letters.put("^", "^");
        letters.put("1", "1");
        letters.put("2", "2");
        letters.put("3", "3");
        letters.put("4", "4");
        letters.put("5", "5");
        letters.put("6", "6");
        letters.put("7", "7");
        letters.put("8", "8");
        letters.put("9", "9");
        letters.put("0", "0");
        letters.put("-", "-");
        letters.put("_", "_");
        letters.put("+", "+");
        letters.put("=", "=");
    }

    public String stringTransliterationFromRussianToEnglishSymbols(String filePathWithString) throws MyException, IOException {
        StringBuilder transliteratedString = new StringBuilder();

        final String stringForTransliteration = readStringFromFile(filePathWithString);

        final char[] charsOfStringForTransliteration = stringForTransliteration.toCharArray();

        for (int i = 1; i < charsOfStringForTransliteration.length; i++) {
            try {
                if (!letters.get(String.valueOf(charsOfStringForTransliteration[i])).equals("")) {
                    transliteratedString.append(letters.get(String.valueOf(charsOfStringForTransliteration[i])));
                }
            } catch (NullPointerException ex) {
                throw new MyException("Test string contains some latin symbols");
            }
        }
        return transliteratedString.toString();
    }

    public String selectIdenticalWordsFromTwoStrings(String firstString, String secondString) {
        String identicalWordsFromTwoStrings = "";

        final String[] wordsFromFirstString = splitStringWithSetRegex(firstString);
        final String[] wordsFromSecondString = splitStringWithSetRegex(secondString);
        for (String wordFromFirstString : wordsFromFirstString) {
            for (String wordFromSecondString : wordsFromSecondString) {
                if (wordFromFirstString.equals(wordFromSecondString)) {
                    String[] wordsArrayWithPossibleDuplication = splitStringWithSetRegex(identicalWordsFromTwoStrings);

                    if (!isWordAlreadySelect(wordsArrayWithPossibleDuplication, wordFromSecondString))
                        identicalWordsFromTwoStrings = identicalWordsFromTwoStrings.concat(wordFromSecondString) + " ";
                }
            }
        }

        if (!identicalWordsFromTwoStrings.equals(""))
            identicalWordsFromTwoStrings = identicalWordsFromTwoStrings.substring(0, identicalWordsFromTwoStrings.length() - 1);
        return identicalWordsFromTwoStrings;
    }
}

