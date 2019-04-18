package com.jazzteam.model.test;

import com.jazzteam.model.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.jazzteam.util.TimeAndDateUtils.getCurrentDate;

public class Test extends Identifiable {
    private String testName;
    private String testCategory;
    private String dateAdd;
    private String dateOfLastEdit;
    private String testTarget;
    private HashMap<Integer, ArrayList<String>> questions;
    private HashMap<Integer, Integer> correctAnswers;

    public Test(String testName, String testCategory, String testTarget, HashMap<Integer, ArrayList<String>> questions, HashMap<Integer, Integer> correctAnswers) {
        this.testName = testName;
        this.testCategory = testCategory;
        this.dateAdd = getCurrentDate();
        this.dateOfLastEdit = "none";
        this.testTarget = testTarget;
        this.questions = questions;
        this.correctAnswers = correctAnswers;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    public void setDateOfLastEdit(String dateOfLastEdit) {
        this.dateOfLastEdit = dateOfLastEdit;
    }

    public String getTestTarget() {
        return testTarget;
    }

    public void setTestTarget(String testTarget) {
        this.testTarget = testTarget;
    }

    public HashMap<Integer, ArrayList<String>> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<Integer, ArrayList<String>> questions) {
        this.questions = questions;
    }

    public HashMap<Integer, Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(HashMap<Integer, Integer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testName, test.testName) &&
                Objects.equals(testCategory, test.testCategory) &&
                Objects.equals(dateAdd, test.dateAdd) &&
                Objects.equals(dateOfLastEdit, test.dateOfLastEdit) &&
                Objects.equals(testTarget, test.testTarget) &&
                Objects.equals(questions, test.questions) &&
                Objects.equals(correctAnswers, test.correctAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testName, testCategory, dateAdd, dateOfLastEdit, testTarget, questions, correctAnswers);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testName='" + testName + '\'' +
                ", testCategory='" + testCategory + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                ", dateOfLastEdit='" + dateOfLastEdit + '\'' +
                ", testTarget='" + testTarget + '\'' +
                ", questions=" + questions +
                ", correctAnswers=" + correctAnswers +
                '}';
    }
}
