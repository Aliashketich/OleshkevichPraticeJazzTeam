package com.jazzteam.model.report;

import com.jazzteam.model.Identifiable;

import static com.jazzteam.util.TimeAndDateUtils.getCurrentDate;

public class Report extends Identifiable {
    private String creationDate;
    private String userLogin;
    private String testName;
    private String rating;

    public Report(String userLogin, String testName, String rating) {
        this.creationDate = getCurrentDate();
        this.userLogin = userLogin;
        this.testName = testName;
        this.rating = rating;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
