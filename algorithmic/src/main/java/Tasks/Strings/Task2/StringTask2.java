package Tasks.Strings.Task2;

import org.apache.log4j.Logger;

/*Напечатать слова, которые встречаются в предложениях только 1 раз*/
class StringTask2 {
    private static final Logger logger = Logger.getLogger(StringTask2.class);

    String printIdenticalWordsFromTwoStrings(String firstString, String secondString) {
        String resultString = "";
        try {
            String[] subString1 = firstString.split("[\\\\s\\\\-\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@\\\\!\\\\ ]+");
            String[] subString2 = secondString.split("[\\\\s\\\\-\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@\\\\!\\\\  ]+");
            for (int i = 0; i < subString1.length; i++) {
                for (int j = 0; j < subString2.length; j++) {
                    if (subString1[i].equals(subString2[j])) {
                        String[] tempStringArray = resultString.split(" ");
                        boolean checkEntryToCurrentResultString = true;
                        for (int t = 0; t < tempStringArray.length; t++) {
                            if (tempStringArray[t].equals(subString2[j])) {
                                checkEntryToCurrentResultString = false;
                                break;
                            }
                        }
                        if (checkEntryToCurrentResultString)
                            resultString = resultString.concat(subString2[j]) + " ";
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
