package com.jazzteam.model;

import com.jazzteam.exception.MyException;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.statistic.Statistic;
import com.jazzteam.model.test.Test;
import com.jazzteam.model.user.User;
import com.jazzteam.model.user.ext.Employee;
import com.jazzteam.model.user.ext.Sysadmin;

import java.util.ArrayList;
import java.util.HashMap;

import static com.jazzteam.util.InformationSecuritySkillUtils.calcSumOfTestRatingsValues;
import static com.jazzteam.util.InformationSecuritySkillUtils.getAverageInformationSecurityLevelValue;

public class Company {
    private ArrayList<Report> allReports;
    private ArrayList<Statistic> allStatistics;
    private ArrayList<Test> allTests;
    private ArrayList<User> allUsers;
    private static Company instance;

    /**
     * Singleton realization to ban the creation of other objects
     *
     * @return company object instance
     */
    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public Company() {

    }

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


    /**
     * method calculation information security skill value for concrete Employee
     *
     * @param employee Employee object
     * @return informationSecuritySkill value
     */
    public String calcInformationSecuritySkillOfEmployee(Employee employee) throws MyException {
        if (employee == null)
            throw new MyException("Employee is null");

        final HashMap<Integer, String> ratingsOfPassedTest = employee.getRatingsOfPassedTest();
        if (ratingsOfPassedTest == null)
            throw new MyException("Ratings is Null");

        final int intEquivalentForSumOfAllRatings = calcSumOfTestRatingsValues(ratingsOfPassedTest);
        if (intEquivalentForSumOfAllRatings == 0)
            throw new MyException("Incorrect values into Ratings. Value is not 'A/B/C/D/E'");

        return getAverageInformationSecurityLevelValue(intEquivalentForSumOfAllRatings, ratingsOfPassedTest.size());
    }
}
