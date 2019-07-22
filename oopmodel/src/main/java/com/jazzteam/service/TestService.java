package com.jazzteam.service;

import com.jazzteam.constants.ExceptionMessage;
import com.jazzteam.exception.MyException;
import com.jazzteam.model.Company;
import com.jazzteam.model.test.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.jazzteam.util.TimeAndDateUtils.getCurrentDate;

public class TestService {
    private TestService() {

    }

    /**
     * Method delete Test object
     *
     * @param test    Test object for deleting
     * @param company Company global context
     * @return true if Test deleted or false if not
     * @throws NullPointerException when test is null
     * @throws MyException          when test is empty
     */
    public static void deleteTest(Test test, Company company) throws MyException {
        if (test == null) {
            throw new NullPointerException(ExceptionMessage.TEST_IS_NULL);
        }

        Test emptyTest = new Test();
        if (test.equals(emptyTest)) {
            throw new MyException(ExceptionMessage.TEST_IS_EMPTY);
        }

        for (int i = 0; i < company.getAllTests().size(); i++) {
            if (company.getAllTests().get(i).equals(test)) {
                company.getAllTests().remove(i);
                break;
            }
        }
    }

    /**
     * Method for insert Test into system
     * also method set current date into Test.dateAdd field in format "dd/MM/yyyy")
     *
     * @param testName       name of new Test
     * @param testCategory   category of new Test
     * @param testTarget     target of new Test
     * @param questions      questions of new Test
     * @param correctAnswers correct answers of new Test
     * @param company        global company context
     * @return created Test object
     * @throws MyException if added Test not found
     */
    public static Test addTest(String testName, String testCategory, String testTarget, HashMap<Integer, ArrayList<String>> questions,
                               HashMap<Integer, Integer> correctAnswers, Company company) throws MyException {
        Test newTest = new Test(testName, testCategory, testTarget, questions, correctAnswers);
        company.addTestToCompany(newTest);
        return company.findTestByName(testName);
    }

    /**
     * Method for editing Test
     * this method call getCurrentDate() for set current date into dateOfLastEdit field
     * this method can not edit questions
     *
     * @param test              object of Test which should be edited
     * @param newTestName       new name value for test
     * @param newTestCategory   new category value for Test
     * @param newTestTarget     new target (employee/sysadmin) for test
     * @param newCorrectAnswers new HashMap<Integer,Integer> with correct test answers
     */
    public static void editTest(Test test, String newTestName, String newTestCategory, String newTestTarget,
                                HashMap<Integer, Integer> newCorrectAnswers) {
        test.setTestName(newTestName);
        test.setCorrectAnswers(newCorrectAnswers);
        test.setDateOfLastEdit(getCurrentDate());
        test.setTestCategory(newTestCategory);
        test.setTestTarget(newTestTarget);
    }
}
