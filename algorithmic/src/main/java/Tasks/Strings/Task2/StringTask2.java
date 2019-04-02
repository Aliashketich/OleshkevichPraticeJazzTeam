package Tasks.Strings.Task2;

import org.apache.log4j.Logger;

import static util.stringsUtil.SplitStringWithMyRegex.splitStringWithMyRegex;


/*Напечатать слова, которые встречаются в предложениях только 1 раз*/

class StringTask2 {
    private static final Logger logger = Logger.getLogger(StringTask2.class);

    String printIdenticalWordsFromTwoStrings(String firstString, String secondString) {
        String resultString = "";
        try {
            String[] subStringFromFirstString = splitStringWithMyRegex(firstString);
            String[] subStringFromSecondString = splitStringWithMyRegex(secondString);
            for (int i = 0; i < subStringFromFirstString.length; i++) {
                for (int j = 0; j < subStringFromSecondString.length; j++) {
                    if (subStringFromFirstString[i].equals(subStringFromSecondString[j])) {
                        String[] stringArrayWithPossibleDuplication = splitStringWithMyRegex(resultString);
                        boolean checkEntryToCurrentResultString = false;
                        for (int t = 0; t < stringArrayWithPossibleDuplication.length; t++) {
                            if (stringArrayWithPossibleDuplication[t].equals(subStringFromSecondString[j])) {
                                checkEntryToCurrentResultString = true;
                                break;
                            }
                        }
                        if (!checkEntryToCurrentResultString)
                            resultString = resultString.concat(subStringFromSecondString[j]) + " ";
                    }
                }
            }
        } catch (NullPointerException ex) {
            logger.error(ex);
            throw ex;
        }
        if (!resultString.equals(""))
            resultString = resultString.substring(0, resultString.length() - 1);
        return resultString;
    }
}