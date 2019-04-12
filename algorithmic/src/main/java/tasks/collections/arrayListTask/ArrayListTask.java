package tasks.collections.arrayListTask;

import java.util.ArrayList;

import static util.strings.StringTaskUtils.splitStringWithSetRegex;
 
/*Create an ArrayList of String called strList that contains 10 string words.
 Create a method called selectionByKeywordAndStringLength(String keyword, int minLength) that returns an ArrayList of String.
  The method should return all the words that contain the keyword and have a length no less than minLength.
   if minLength == -1, then it returns all words with any length.*/

public class ArrayListTask {

    public ArrayList<String> selectionByKeywordAndStringLength(ArrayList<String> entryArrayList, String keyword, int minStringLength) {
        if (entryArrayList == null)
            throw new NullPointerException();

        ArrayList<String> selectionResult = new ArrayList<>();

        if (minStringLength != -1) {
            for (String arrayListString : entryArrayList) {
                if (arrayListString.length() >= minStringLength) {
                    final String[] wordsFromArrayListElement = splitStringWithSetRegex(arrayListString);

                    if (isArrayListStringContainsKeyword(wordsFromArrayListElement, keyword))
                        selectionResult.add(arrayListString);
                }
            }
            return selectionResult;

        } else
            return entryArrayList;
    }

    private boolean isArrayListStringContainsKeyword(String[] wordsFromArrayListElement, String keyword) {
        for (String wordFromArrayListElement : wordsFromArrayListElement) {
            if (wordFromArrayListElement.equals(keyword)) {
                return true;
            }
        }
        return false;
    }
}
