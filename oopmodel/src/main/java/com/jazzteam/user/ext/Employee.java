package com.jazzteam.user.ext;

import com.jazzteam.notification.Notification;
import com.jazzteam.report.Report;
import com.jazzteam.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee extends User {
    private String department;
    private String informationSecuritySkill;
    private HashMap<Integer, String> ratingsOfPassedTest;

    public Employee(String department, String informationSecuritySkill, HashMap<Integer, String> ratingsOfPassedTest) {
        this.department = department;
        this.informationSecuritySkill = informationSecuritySkill;
        this.ratingsOfPassedTest = ratingsOfPassedTest;
    }

    public Employee(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, Report report, String role, String department, String informationSecuritySkill, HashMap<Integer, String> ratingsOfPassedTest) {
        super(age, notifications, email, login, password, name, surname, report, role);
        this.department = department;
        this.informationSecuritySkill = informationSecuritySkill;
        this.ratingsOfPassedTest = ratingsOfPassedTest;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInformationSecuritySkill() {
        return informationSecuritySkill;
    }

    public void setInformationSecuritySkill(String informationSecuritySkill) {
        this.informationSecuritySkill = informationSecuritySkill;
    }

    public HashMap<Integer, String> getRatingsOfPassedTest() {
        return ratingsOfPassedTest;
    }

    public void setRatingsOfPassedTest(HashMap<Integer, String> ratingsOfPassedTest) {
        this.ratingsOfPassedTest = ratingsOfPassedTest;
    }
}
