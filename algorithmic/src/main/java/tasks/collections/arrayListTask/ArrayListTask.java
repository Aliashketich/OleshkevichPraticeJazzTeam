package tasks.collections.arrayListTask;

import java.util.ArrayList;

import static util.strings.StringTaskUtils.splitStringWithSetRegex;
 
/*Create an ArrayList of String called strList that contains 10 string words.
 Create a method called selectionByKeywordAndStringLength(String keyword, int minLength) that returns an ArrayList of String.
  The method should return all the words that contain the keyword and have a length no less than minLength.
   if minLength == -1, then it returns all words with any length.*/

class ArrayListTask {

    ArrayList<String> selectionByKeywordAndStringLength(ArrayList<String> entryArrayList, String keyword, int minStringLength) {
        if (entryArrayList == null)
            throw new NullPointerException();
        ArrayList<String> selectionResult = new ArrayList<>();
        if (minStringLength != -1)
            for (int i = 0; i < entryArrayList.size(); i++) {
                if (entryArrayList.get(i).length() >= minStringLength) {
                    String[] wordsFromArrayListElement = splitStringWithSetRegex(entryArrayList.get(i));
                    boolean checkEntryKeywordInArrayListString = false;
                    for (int j = 0; j < wordsFromArrayListElement.length; j++) {
                        if (wordsFromArrayListElement[j].equals(keyword)) {
                            checkEntryKeywordInArrayListString = true;
                            break;
                        }
                    }
                    if (checkEntryKeywordInArrayListString)
                        selectionResult.add(entryArrayList.get(i));
                }
            }
        else
            selectionResult = entryArrayList;

        return selectionResult;
    }

}
