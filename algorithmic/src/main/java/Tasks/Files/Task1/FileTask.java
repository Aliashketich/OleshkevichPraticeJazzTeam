/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package Tasks.Files.Task1;

import exception.MyExceptionForFileWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static util.fileUtil.GetTextFromFile.readFile;

class FileTask {

    ArrayList<String> buildSquare(String filePathFromTest) throws IOException, MyExceptionForFileWork {
        ArrayList<String> answer;
        ArrayList<String> wordsSource = readFile(filePathFromTest);

        /*@ TODO: 30.03.2019 реализовать алгоритм. */
        boolean squareIsBuild = false;
        while (!squareIsBuild) {
            int maxWordLength = getStringListMaxElementLength(wordsSource);
            int minWordLength = getStringListMinElementLength(wordsSource);
            int numbersWordsWithMaxLength = getNumbersOfWordsWithSetLength(wordsSource, maxWordLength);
            HashMap<Integer, ArrayList<String>> wordsGroupWithSameLength = separateWordsIntoLengthGroups(wordsSource, maxWordLength, minWordLength);

            int numbersOfWordsInGroupWithOneLength;
            for (int i = minWordLength; i < maxWordLength + 1; i++) {
                numbersOfWordsInGroupWithOneLength = getNumberOfWordsInGroup(wordsGroupWithSameLength, i);
                if (numbersOfWordsInGroupWithOneLength >= minWordLength) {
                    ArrayList<String> arrayListOfWordWithSetLength = wordsGroupWithSameLength.get(i);
                    for (int j = 0; j < numbersOfWordsInGroupWithOneLength; j++) {
                        int countOfAcceptLetters = 0;
                        char[] wordFromArrayListOfWordWithSetLength = arrayListOfWordWithSetLength.get(j).toCharArray();
                        for (int t = 0; t < wordFromArrayListOfWordWithSetLength.length; t++) {
                            if (!arrayListHasSomeWordOnThisLetter(arrayListOfWordWithSetLength, wordFromArrayListOfWordWithSetLength[t], Arrays.toString(wordFromArrayListOfWordWithSetLength)))
                                break;
                            else countOfAcceptLetters++;
                        }
                        if (countOfAcceptLetters == arrayListOfWordWithSetLength.get(j).length()) {
                            /*@todo Алгоритм генерации ArrayList<String> всех возможных комбинаций слов. Проверить каждую из них на удовлетворению условию. */
                            String firstWordOfResultArrayList = arrayListOfWordWithSetLength.get(j);
                            ArrayList<String> answerVariant = new ArrayList<>();
                            for (int i1 = 0; i1 < firstWordOfResultArrayList.length(); i1++) {
                                answerVariant.add(i1, arrayListOfWordWithSetLength.get(j++));
                            }
                            System.out.println(answerVariant);
                        }
                    }
                }
            }


            squareIsBuild = true;
        }
        answer = wordsSource;
        return answer;
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
