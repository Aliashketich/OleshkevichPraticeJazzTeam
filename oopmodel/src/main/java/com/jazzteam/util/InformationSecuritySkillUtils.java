package com.jazzteam.util;

import java.util.HashMap;

public class InformationSecuritySkillUtils {
    /**
     * method for calculation overage sun of all ratings
     *
     * @param ratingsOfPassedTest hashMap with ratings of all passed by User tests
     * @return int equivalent for sum of all ratings
     */
    public static int calcSumOfTestRatingsValues(HashMap<Integer, String> ratingsOfPassedTest) {
        int intEquivalentForSumOfAllRatings = 0;
        for (int i = 0; i < ratingsOfPassedTest.size(); i++) {
            switch (ratingsOfPassedTest.get(i)) {
                case "A":
                    intEquivalentForSumOfAllRatings += 5;
                    break;
                case "B":
                    intEquivalentForSumOfAllRatings += 4;
                    break;
                case "C":
                    intEquivalentForSumOfAllRatings += 3;
                    break;
                case "D":
                    intEquivalentForSumOfAllRatings += 2;
                    break;
                case "F":
                    intEquivalentForSumOfAllRatings += 1;
                    break;
                default:
                    intEquivalentForSumOfAllRatings = 0;
            }
        }
        return intEquivalentForSumOfAllRatings;
    }

    /**
     * method for getting averaged Information Security Skill level
     *
     * @param intEquivalentForSumOfAllRatings int equivalent for sum of all ratings
     * @param numberOfTest                    number of all passed tests by User
     * @return averaged Information Security Skill level
     */
    public static String getAverageInformationSecurityLevelValue(int intEquivalentForSumOfAllRatings, int numberOfTest) {
        switch (intEquivalentForSumOfAllRatings / numberOfTest) {
            case 5:
                return "A";
            case 4:
                return "B";
            case 3:
                return "C";
            case 2:
                return "D";
            case 1:
                return "E";
            default:
                return null;
        }
    }
}
