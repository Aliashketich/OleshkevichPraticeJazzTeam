package com.jazzteam;

import com.jazzteam.report.Report;
import com.jazzteam.statistic.Statistic;
import com.jazzteam.test.Test;
import com.jazzteam.user.User;

import java.util.ArrayList;

public class Company {
    private ArrayList<Report> allReports;
    private ArrayList<Statistic> allStatistics;
    private ArrayList<Test> allTests;
    private ArrayList<User> allUsers;

    public Company(ArrayList<Report> allReports, ArrayList<Statistic> allStatistics, ArrayList<Test> allTests, ArrayList<User> allUsers) {
        this.allReports = allReports;
        this.allStatistics = allStatistics;
        this.allTests = allTests;
        this.allUsers = allUsers;
    }

    public Company() {
    }

    public ArrayList<Report> getAllReports() {
        return allReports;
    }

    public void setAllReports(ArrayList<Report> allReports) {
        this.allReports = allReports;
    }

    public ArrayList<Statistic> getAllStatistics() {
        return allStatistics;
    }

    public void setAllStatistics(ArrayList<Statistic> allStatistics) {
        this.allStatistics = allStatistics;
    }

    public ArrayList<Test> getAllTests() {
        return allTests;
    }

    public void setAllTests(ArrayList<Test> allTests) {
        this.allTests = allTests;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }
}
