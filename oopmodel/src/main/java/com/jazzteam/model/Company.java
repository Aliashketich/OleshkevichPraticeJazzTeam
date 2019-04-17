package com.jazzteam.model;

import com.jazzteam.model.report.Report;
import com.jazzteam.model.statistic.Statistic;
import com.jazzteam.model.test.Test;
import com.jazzteam.model.user.User;
import com.jazzteam.model.user.ext.Employee;
import com.jazzteam.model.user.ext.Sysadmin;

import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * method for getting all users with role "employee"
     *
     * @return ArrayList<Employee> with all employees in Company
     */
    public ArrayList<Employee> findAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getRole().equals("employee"))
                employees.add((Employee) user);
        }
        return employees;
    }

    /**
     * method for getting all users with role "employee"
     *
     * @return ArrayList<Employee> with all employees in Company
     */
    public ArrayList<Sysadmin> findAllSysadmins() {
        ArrayList<Sysadmin> sysadmins = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getRole().equals("sysadmin"))
                sysadmins.add((Sysadmin) user);
        }
        return sysadmins;
    }

// TODO: 17.04.2019 Refactor it!!!

    /**
     * method calculation information security skill value for concrete Employee
     *
     * @param employee Employee object
     * @return informationSecuritySkill value
     */
    public String calcInformationSecuritySkillOfEmployee(Employee employee) {
        final HashMap<Integer, String> ratingsOfPassedTest = employee.getRatingsOfPassedTest();
        final int countOfTests = ratingsOfPassedTest.size();
        int sumStringValues = 0;
        for (int i = 0; i < countOfTests; i++) {
            switch (ratingsOfPassedTest.get(i)) {
                case "A":
                    sumStringValues += 5;
                    break;
                case "B":
                    sumStringValues += 4;
                    break;
                case "C":
                    sumStringValues += 3;
                    break;
                case "D":
                    sumStringValues += 2;
                    break;
                case "F":
                    sumStringValues += 1;
                    break;
                default:
                    sumStringValues = 0;
            }
        }
        String informationSecuritySkillOfEmployee = "";

        switch (sumStringValues / countOfTests) {
            case 5:
                informationSecuritySkillOfEmployee = "A";
                break;
            case 4:
                informationSecuritySkillOfEmployee = "B";
                break;
            case 3:
                informationSecuritySkillOfEmployee = "C";
                break;
            case 2:
                informationSecuritySkillOfEmployee = "D";
                break;
            case 1:
                informationSecuritySkillOfEmployee = "F";
                break;
        }

        return informationSecuritySkillOfEmployee;
    }
}
