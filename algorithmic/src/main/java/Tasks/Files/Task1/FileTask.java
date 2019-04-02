/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package Tasks.Files.Task1;

import exception.MyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static util.file.GetTextFromFile.readFile;
import static util.fileTask.FileTaskUtils.*;

class FileTask {
    ArrayList<String> buildSquare(String filePathFromTest) throws IOException, MyException {
        ArrayList<String> answer;
        ArrayList<String> wordsSource = readFile(filePathFromTest);

        int maxWordLength = getStringListMaxElementLength(wordsSource);
        int minWordLength = getStringListMinElementLength(wordsSource);

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
                                    return answer;
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
