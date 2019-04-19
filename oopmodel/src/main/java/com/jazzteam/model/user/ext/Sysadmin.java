package com.jazzteam.model.user.ext;

import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Sysadmin extends User {
    private int experience;
    private HashMap<Integer, String> passedTestRating;
    private String workResultRating;

    private static final String SYSADMIN_ROLE = "sysadmin";

    public Sysadmin() {

    }

    public Sysadmin(int experience, HashMap<Integer, String> passedTestRating, String workResultRating) {
        this.experience = experience;
        this.passedTestRating = passedTestRating;
        this.workResultRating = workResultRating;
    }

    public Sysadmin(int age, ArrayList<Notification> notifications, String email, String login, String password, String name,
                    String surname, ArrayList<Report> reports, int experience, HashMap<Integer, String> passedTestRating,
                    String workResultRating) {
        super(age, notifications, email, login, password, name, surname, reports, SYSADMIN_ROLE);
        this.experience = experience;
        this.passedTestRating = passedTestRating;
        this.workResultRating = workResultRating;
    }

    public Sysadmin(int age, ArrayList<Notification> notifications, String email, String login, String password, String name,
                    String surname, ArrayList<Report> reports, String role, int experience, HashMap<Integer, String> passedTestRating,
                    String workResultRating) {
        super(age, notifications, email, login, password, name, surname, reports, role);
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
