package util.file;

import exception.MyException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static util.strings.StringTaskUtils.saveInUnicode;

public class FileTaskUtils {
    public static boolean checkRectangleForSatisfaction(ArrayList<String> arrayListOfWordWithSetLength, ArrayList<String> rectangleOfWordForCorrectCheck, int wordLength) throws MyException {
        if (wordLength == 0)
            throw new MyException("Word length can not be equals zero!");
        char[][] wordsCharsArrayForSatisfaction = new char[wordLength][wordLength];
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < wordLength; j++) {
                wordsCharsArrayForSatisfaction[i][j] = rectangleOfWordForCorrectCheck.get(j).charAt(i);
            }
        }
        int countOfCorrectWords = 0;
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < arrayListOfWordWithSetLength.size(); j++) {
                String wordFromVocabulary = new String(arrayListOfWordWithSetLength.get(j).getBytes());
                String wordFromCharArray = new String(wordsCharsArrayForSatisfaction[i].clone());
                if (wordFromCharArray.equals(wordFromVocabulary)) {
                    countOfCorrectWords++;
                    break;
                }
            }
        }
        return countOfCorrectWords == wordLength;
    }

    public static boolean arrayListHasSomeWordOnThisLetter(ArrayList<String> arrayListOfWordWithSetLength, char c, String excludeWord) {
        for (int i = 0; i < arrayListOfWordWithSetLength.size(); i++) {
            char[] chars = arrayListOfWordWithSetLength.get(i).toCharArray();
            if ((chars[0] == c) && (!arrayListOfWordWithSetLength.get(i).equals(excludeWord))) {
                return true;
            }
        }
        return false;
    }


    public static int getNumberOfWordsInGroup(HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength, int wordsLengthInGroup) {
        ArrayList<String> arrayListOfWordGroup = wordsGroupWithSameLength.get(wordsLengthInGroup);
        return arrayListOfWordGroup.size();
    }

    public static HashMap<Integer, ArrayList<String>> separateWordsIntoLengthGroups(ArrayList<String> wordsSource, int maxWordLength, int minWordLength) {
        HashMap<Integer, ArrayList<String>> answerHashMap = new HashMap<>();
        for (int i = minWordLength; i < maxWordLength + 1; i++) {
            ArrayList<String> arrayListOfWordsWithSameLength = new ArrayList<>();
            for (int j = 0, t = 0; j < wordsSource.size(); j++) {
                if (wordsSource.get(j).length() == i) {
                    arrayListOfWordsWithSameLength.add(t, wordsSource.get(j));
                    t++;
                }
            }
            answerHashMap.put(i, arrayListOfWordsWithSameLength);
        }
        return answerHashMap;
    }

    public static int getStringListMinElementLength(ArrayList<String> wordsSource) {
        int minElementLength = wordsSource.get(0).length();
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() < minElementLength)
                minElementLength = wordsSource.get(i).length();
        }
        return minElementLength;

    }

    public static int getStringListMaxElementLength(ArrayList<String> wordsSource) {
        int maxElementLength = 0;
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() > maxElementLength)
                maxElementLength = wordsSource.get(i).length();
        }
        return maxElementLength;
    }

    public static ArrayList<String> readAllStringsFromFile(String path) throws IOException, MyException {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        Scanner scanFile = new Scanner(new File(path));
        while (scanFile.hasNext()) {
            stringsFromFile.add(scanFile.next());
        }
        scanFile.close();
        if (!stringsFromFile.isEmpty())
            return stringsFromFile;
        else
            throw new MyException("Test file is empty!");
    }

    public static String readStringFromFile(String path) throws MyException, IOException {
        String stringFromFile = "";

        Scanner scanFile = new Scanner(new File(path));
        while (scanFile.hasNext()) {
            stringFromFile = scanFile.nextLine();
        }
        scanFile.close();
        String stringSaveInUnicode = saveInUnicode(stringFromFile);
        if (!stringSaveInUnicode.equals("")) {
            return stringSaveInUnicode;
        } else
            throw new MyException("Test string must be not empty!");
    }

    public static HashMap<String, String> getVocabularyFromFile(String vocabularyFilePath) throws IOException, MyException {

        ArrayList<String> stringArrayListFromReadTextFromFile = readAllStringsFromFile(vocabularyFilePath);
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
