package com.jazzteam.test;

import com.jazzteam.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;

public class Test extends Identifiable {
    private String testName;
    private String testCategory;
    private String dateAdd;
    private String dateOfLastEdit;
    private String testTarget;
    private HashMap<Integer, ArrayList<String>> questions;
    private HashMap<Integer, Integer> correctAnswers;

    public Test(String testName, String testCategory, String dateAdd, String dateOfLastEdit, String testTarget, HashMap<Integer, ArrayList<String>> questions, HashMap<Integer, Integer> correctAnswers) {
        this.testName = testName;
        this.testCategory = testCategory;
        this.dateAdd = dateAdd;
        this.dateOfLastEdit = dateOfLastEdit;
        this.testTarget = testTarget;
        this.questions = questions;
        this.correctAnswers = correctAnswers;
    }

    public Test() {
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
}
