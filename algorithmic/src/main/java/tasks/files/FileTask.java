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

class FileTask {
    ArrayList<String> buildLargestRectangleOfWords(String filePathWithWordsSource) throws IOException, MyException {
        ArrayList<String> largestRectangleOfWords;
        ArrayList<String> wordsSourceForBuilding = readAllStringsFromFile(filePathWithWordsSource);

        int maxWordLength = getStringListMaxElementLength(wordsSourceForBuilding);
        int minWordLength = getStringListMinElementLength(wordsSourceForBuilding);

        HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength = separateWordsIntoLengthGroups(wordsSourceForBuilding, maxWordLength, minWordLength);

        for (int currentWordLength = maxWordLength; currentWordLength > minWordLength - 1; currentWordLength--) {
            int numbersOfWordsInGroupWithOneLength = getNumberOfWordsInGroup(wordsGroupWithSameLength, currentWordLength);

            if (numbersOfWordsInGroupWithOneLength >= currentWordLength) {

                ArrayList<String> arrayListOfWordWithSetLength = wordsGroupWithSameLength.get(currentWordLength);

                for (int j = 0; j < numbersOfWordsInGroupWithOneLength; j++) {

                    int countOfAcceptLetters = 0;
                    char[] wordFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(j).toCharArray();
                    for (char aWordFromArrayListOfWordWithSetLength : wordFromArrayListOfWordWithSetLength) {
                        if (!arrayListHasSomeWordOnThisLetter(arrayListOfWordWithSetLength, aWordFromArrayListOfWordWithSetLength, Arrays.toString(wordFromArrayListOfWordWithSetLength)))
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
}
