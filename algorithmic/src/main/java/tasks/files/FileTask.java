/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package tasks.files;

import exception.MyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static util.file.FileTaskUtils.*;

public class FileTask {
    public ArrayList<String> buildLargestRectangleOfWords(String filePathWithWordsSource) throws IOException, MyException {
        final ArrayList<String> wordsSourceForBuilding = readAllStringsFromFile(filePathWithWordsSource);

        final int maxWordLength = getStringListMaxElementLength(wordsSourceForBuilding);
        final int minWordLength = getStringListMinElementLength(wordsSourceForBuilding);

        final HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength = separateWordsIntoLengthGroups(wordsSourceForBuilding, maxWordLength, minWordLength);

        ArrayList<String> largestRectangleOfWords;

        for (int currentWordLength = maxWordLength; currentWordLength > minWordLength - 1; currentWordLength--) {
            int numbersOfWordsInGroupWithOneLength = getNumberOfWordsInGroup(wordsGroupWithSameLength, currentWordLength);

            if (numbersOfWordsInGroupWithOneLength >= currentWordLength) {
                ArrayList<String> arrayListOfWordWithSetLength = wordsGroupWithSameLength.get(currentWordLength);

                for (int j = 0; j < numbersOfWordsInGroupWithOneLength; j++) {
                    int countOfAcceptLetters = getNumberOfLetterContainsInWordsFromArrayListWithSetLength(arrayListOfWordWithSetLength, j);

                    if (countOfAcceptLetters == arrayListOfWordWithSetLength.get(j).length()) {
                        final int amountOfAllPossibleCombination = numbersOfWordsInGroupWithOneLength - currentWordLength;

                        for (int numberOfCheckCombination = 0; numberOfCheckCombination < amountOfAllPossibleCombination; numberOfCheckCombination++) {
                            for (int countAddToRectangleCombination = 0, count = 0; countAddToRectangleCombination < numbersOfWordsInGroupWithOneLength - 4; countAddToRectangleCombination++, count++) {
                                ArrayList<String> rectangleOfWordForCorrectCheck = buildCombinationOfWord(currentWordLength, arrayListOfWordWithSetLength, count);

                                if (checkRectangleForSatisfaction(arrayListOfWordWithSetLength, rectangleOfWordForCorrectCheck, currentWordLength)) {
                                    largestRectangleOfWords = rectangleOfWordForCorrectCheck;
                                    return largestRectangleOfWords;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new MyException("Solution not found!");
    }

    public ArrayList<String> buildCombinationOfWord(int currentWordLength, ArrayList<String> arrayListOfWordWithSetLength, int count) {
        ArrayList<String> combinationOfWord = new ArrayList<>();
        for (int y = 0; y < currentWordLength; y++) {
            String elementFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(y + count);
            combinationOfWord.add(y, elementFromArrayListOfWordWithSetLength);
        }
        return combinationOfWord;
    }

    private int getNumberOfLetterContainsInWordsFromArrayListWithSetLength(ArrayList<String> arrayListOfWordWithSetLength, int j) {
        int countOfAcceptLetters = 0;
        char[] wordFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(j).toCharArray();
        for (char aWordFromArrayListOfWordWithSetLength : wordFromArrayListOfWordWithSetLength) {
            if (!arrayListHasSomeWordOnThisLetter(arrayListOfWordWithSetLength, aWordFromArrayListOfWordWithSetLength, Arrays.toString(wordFromArrayListOfWordWithSetLength)))
                break;
            else countOfAcceptLetters++;
        }
        return countOfAcceptLetters;
    }
}
