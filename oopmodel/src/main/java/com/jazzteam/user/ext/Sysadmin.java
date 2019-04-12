package com.jazzteam.user.ext;

import com.jazzteam.notification.Notification;
import com.jazzteam.report.Report;
import com.jazzteam.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Sysadmin extends User {
    private int experience;
    private HashMap<Integer, String> passedTestRating;
    private String workResultRating;

    public Sysadmin(int experience, HashMap<Integer, String> passedTestRating, String workResultRating) {
        this.experience = experience;
        this.passedTestRating = passedTestRating;
        this.workResultRating = workResultRating;
    }

    public Sysadmin(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, Report report, String role, int experience, HashMap<Integer, String> passedTestRating, String workResultRating) {
        super(age, notifications, email, login, password, name, surname, report, role);
        this.experience = experience;
        this.passedTestRating = passedTestRating;
        this.workResultRating = workResultRating;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public HashMap<Integer, String> getPassedTestRating() {
        return passedTestRating;
    }

    public void setPassedTestRating(HashMap<Integer, String> passedTestRating) {
        this.passedTestRating = passedTestRating;
    }

    public String getWorkResultRating() {
        return workResultRating;
    }

    public void setWorkResultRating(String workResultRating) {
        this.workResultRating = workResultRating;
    }
}
