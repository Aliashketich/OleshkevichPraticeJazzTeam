/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package Tasks.Files.Task1;

import exception.MyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static util.fileUtil.GetTextFromFile.readFile;

class FileTask {

    ArrayList<String> buildSquare(String filePathFromTest) throws IOException, MyException {
        ArrayList<String> answer = null;
        ArrayList<String> wordsSource = readFile(filePathFromTest);

        //TODO: 30.03.2019 реализовать алгоритм.
        int maxWordLength = getStringListMaxElementLength(wordsSource);
        int minWordLength = getStringListMinElementLength(wordsSource);
        int numbersWordsWithMaxLength = getNumbersOfWordsWithSetLength(wordsSource, maxWordLength);

        HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength = separateWordsIntoLengthGroups(wordsSource, maxWordLength, minWordLength);

        for (int currentWordLength = maxWordLength; currentWordLength > minWordLength - 1; currentWordLength--) {
            int numbersOfWordsInGroupWithOneLength = getNumberOfWordsInGroup(wordsGroupWithSameLength, currentWordLength);

            if (numbersOfWordsInGroupWithOneLength >= currentWordLength) {

                ArrayList<String> arrayListOfWordWithSetLength = wordsGroupWithSameLength.get(currentWordLength);

                for (int j = 0; j < numbersOfWordsInGroupWithOneLength; j++) {

                    int countOfAcceptLetters = 0;
                    char[] wordFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(j).toCharArray();
                    for (int t = 0; t < wordFromArrayListOfWordWithSetLength.length; t++) {
                        if (!arrayListHasSomeWordOnThisLetter(arrayListOfWordWithSetLength, wordFromArrayListOfWordWithSetLength[t], Arrays.toString(wordFromArrayListOfWordWithSetLength)))
                            break;
                        else countOfAcceptLetters++;
                    }

                    if (countOfAcceptLetters == arrayListOfWordWithSetLength.get(j).length()) {
                        ArrayList<String> rectangleOfWordForCorrectCheck;
                        int amountOfAllPossibleCombination = numbersOfWordsInGroupWithOneLength - currentWordLength;
                        for (int numberOfCheckCombination = 0; numberOfCheckCombination < amountOfAllPossibleCombination; numberOfCheckCombination++) {
                            for (int countAddToRectangleCombination = 0, count = 0; countAddToRectangleCombination < numbersOfWordsInGroupWithOneLength - 4; countAddToRectangleCombination++, count++) {
                                rectangleOfWordForCorrectCheck = new ArrayList<>();
                                for (int y = 0; y < currentWordLength; y++) {
                                    String elementFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(y + count);
                                    rectangleOfWordForCorrectCheck.add(y, elementFromArrayListOfWordWithSetLength);
                                }
                                if (checkRectangleForSatisfaction(arrayListOfWordWithSetLength, rectangleOfWordForCorrectCheck, currentWordLength)) {
                                    answer = rectangleOfWordForCorrectCheck;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (answer != null)
            return answer;
        else throw new MyException("Solution not found!");
    }

    private boolean checkRectangleForSatisfaction(ArrayList<String> arrayListOfWordWithSetLength, ArrayList<String> rectangleOfWordForCorrectCheck, int wordLength) {

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

    private boolean arrayListHasSomeWordOnThisLetter(ArrayList<String> arrayListOfWordWithSetLength, char c, String excludeWord) {
        for (int i = 0; i < arrayListOfWordWithSetLength.size(); i++) {
            char[] chars = arrayListOfWordWithSetLength.get(i).toCharArray();
            if ((chars[0] == c) && (!arrayListOfWordWithSetLength.get(i).equals(excludeWord))) {
                return true;
            }
        }
        return false;
    }


    private int getNumberOfWordsInGroup(HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength, int wordsLengthInGroup) {
        ArrayList<String> arrayListOfWordGroup = wordsGroupWithSameLength.get(wordsLengthInGroup);
        return arrayListOfWordGroup.size();
    }

    private HashMap<Integer, ArrayList<String>> separateWordsIntoLengthGroups(ArrayList<String> wordsSource, int maxWordLength, int minWordLength) {
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

    private int getNumbersOfWordsWithSetLength(ArrayList<String> wordsSource, int maxWordLength) {
        int numbersOfWordsWithSetLength = 0;
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() == maxWordLength)
                numbersOfWordsWithSetLength++;
        }
        return numbersOfWordsWithSetLength;
    }

    private int getStringListMinElementLength(ArrayList<String> wordsSource) {
        int minElementLength = wordsSource.get(0).length();
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() < minElementLength)
                minElementLength = wordsSource.get(i).length();
        }
        return minElementLength;

    }

    private int getStringListMaxElementLength(ArrayList<String> wordsSource) {
        int maxElementLength = 0;
        for (int i = 0; i < wordsSource.size(); i++) {
            if (wordsSource.get(i).length() > maxElementLength)
                maxElementLength = wordsSource.get(i).length();
        }
        return maxElementLength;
    }

}
