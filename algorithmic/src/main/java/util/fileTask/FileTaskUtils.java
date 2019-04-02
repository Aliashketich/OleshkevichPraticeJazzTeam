package util.fileTask;

import java.util.ArrayList;
import java.util.HashMap;

public class FileTaskUtils {
    public static boolean checkRectangleForSatisfaction(ArrayList<String> arrayListOfWordWithSetLength, ArrayList<String> rectangleOfWordForCorrectCheck, int wordLength) {

        char[][] wordsCharsArrayForSatisfaction = new char[wordLength][wordLength];
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < wordLength; j++) {
                wordsCharsArrayForSatisfaction[i][j] = rectangleOfWordForCorrectCheck.get(j).charAt(i);
            }
        }
        int count = 0;
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < arrayListOfWordWithSetLength.size(); j++) {
                String wordFromVocabulary = new String(arrayListOfWordWithSetLength.get(j).getBytes());
                String wordFromCharArray = new String(wordsCharsArrayForSatisfaction[i].clone());
                if (wordFromCharArray.equals(wordFromVocabulary)) {
                    count++;
                    break;
                }
            }
        }
        return count == wordLength;
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

    public static int getNumbersOfWordsWithSetLength(ArrayList<String> wordsSource, int maxWordLength) {
        int numbersOfWordsWithSetLength = 0;
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() == maxWordLength)
                numbersOfWordsWithSetLength++;
        }
        return numbersOfWordsWithSetLength;
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

}
