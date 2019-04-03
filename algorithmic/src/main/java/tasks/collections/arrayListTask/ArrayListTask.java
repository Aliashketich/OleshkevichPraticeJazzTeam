package tasks.collections.arrayListTask;

import java.util.ArrayList;

import static util.strings.StringTaskUtils.splitStringWithSetRegex;
 
/*Create an ArrayList of String called strList that contains 10 string words.
 Create a method called search(String keyword, int minLength) that returns an ArrayList of String.
  The method should return all the words that contain the keyword and have a length no less than minLength.
   if minLength == -1, then it returns all words with any length.*/

class ArrayListTask {

    ArrayList<String> search(ArrayList<String> stringArrayList, String keyword, int minLength) {
        ArrayList<String> resultArrayList = new ArrayList<>();
        try {
            if (minLength != -1)
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (stringArrayList.get(i).length() >= minLength) {
                        String[] wordsFromArrayListElement = splitStringWithSetRegex(stringArrayList.get(i));
                        boolean checkEntryKeywordInArrayListString = false;
                        for (int j = 0; j < wordsFromArrayListElement.length; j++) {
                            if (wordsFromArrayListElement[j].equals(keyword)) {
                                checkEntryKeywordInArrayListString = true;
                                break;
                            }
                        }
                        if (checkEntryKeywordInArrayListString)
                            resultArrayList.add(stringArrayList.get(i));
                    }
                }
            else
                resultArrayList = stringArrayList;
        } catch (NullPointerException e) {
            throw e;
        }
        catch (IndexOutOfBoundsException ex) {
            throw ex; //По-дргуому не работает тест
        }
        return resultArrayList;
    }

}
