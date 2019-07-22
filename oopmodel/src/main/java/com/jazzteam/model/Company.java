package com.jazzteam.model;

import com.jazzteam.constants.Constant;
import com.jazzteam.constants.ExceptionMessage;
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

    public Company(ArrayList<Report> allReports, ArrayList<Statistic> allStatistics, ArrayList<Test> allTests,
                   ArrayList<User> allUsers) {
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
     * Method for getting all users with role "employee"
     *
     * @return ArrayList<Employee> with all employees in Company
     */
    public ArrayList<Employee> findAllEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();
        for (User user : allUsers) {
            if (Constant.EMPLOYEE_ROLE.equals(user.getRole()))
                employeesList.add((Employee) user);
        }
        return employeesList;
    }

    /**
     * Method for getting all users with role "sysadmin"
     *
     * @return ArrayList<Sysadmin> with all sysadmins in Company
     */
    public ArrayList<Sysadmin> findAllSysadmins() {
        ArrayList<Sysadmin> sysadminsList = new ArrayList<>();
        for (User user : allUsers) {
            if (Constant.SYSADMIN_ROLE.equals(user.getRole()))
                sysadminsList.add((Sysadmin) user);
        }
        return sysadminsList;
    }

    /**
     * Method calculation information security skill value for concrete Employee
     *
     * @param employee Employee object
     * @return informationSecuritySkill value
     */
    public String calcInformationSecuritySkillOfEmployee(Employee employee) throws MyException {
        if (employee == null)
            throw new MyException(ExceptionMessage.EMPLOYEE_IS_NULL);

        final HashMap<Integer, String> ratingsOfPassedTest = employee.getRatingsOfPassedTest();
        if (ratingsOfPassedTest == null)
            throw new MyException(ExceptionMessage.RATINGS_IS_NULL);

        final int intEquivalentForSumOfAllRatings = calcSumOfTestRatingsValues(ratingsOfPassedTest);
        if (intEquivalentForSumOfAllRatings == 0)
            throw new MyException(ExceptionMessage.INCORRECT_RATING_VALUE);

        return getAverageInformationSecurityLevelValue(intEquivalentForSumOfAllRatings, ratingsOfPassedTest.size());
    }

    /**
     * This method set a new User to company
     *
     * @param newUser User object for adding to all company users
     */
    public void addUserToCompany(User newUser) throws MyException {
        User emptyUser = new User();
        if (newUser.equals(emptyUser)) {
            throw new MyException(ExceptionMessage.USER_IS_EMPTY);
        }

        for (User anUser : allUsers) {
            if (anUser.getLogin().equals(newUser.getLogin())) {
                throw new MyException(ExceptionMessage.USER_WITH_THAT_LOGIN_ALREADY_EXIST);
            }
            if (anUser.getEmail().equals(newUser.getEmail())) {
                throw new MyException(ExceptionMessage.USER_WITH_THAT_EMAIL_ALREADY_EXIST);
            }
        }
        allUsers.add(newUser);
    }

    /**
     * This method set a new Test to company
     *
     * @param newTest Test object for adding to all company tests
     */
    public void addTestToCompany(Test newTest) throws MyException {
        Test emptyTest = new Test();
        if (newTest.equals(emptyTest)) {
            throw new MyException(ExceptionMessage.TEST_IS_EMPTY);
        }

        for (Test anTest : allTests) {
            if (anTest.getTestName().equals(newTest.getTestName())) {
                throw new MyException(ExceptionMessage.TEST_WITH_THAT_NAME_ALREADY_EXIST);
            }
        }
        allTests.add(newTest);
    }

    /**
     * This method find User in company by User login
     *
     * @param login login of User
     * @return founded User
     * @throws MyException if User not found
     */
    public User findUserByLogin(String login) throws MyException {
        User user = new User();
        for (User anUser : allUsers) {
            if (login.equals(anUser.getLogin())) {
                user = anUser;
            }
        }
        if (!user.equals(new User()))
            return user;
        else throw new MyException(ExceptionMessage.USER_NOT_FOUND);
    }

    /**
     * This method find Test in company by Test name
     *
     * @param testName name of test
     * @return founded Test
     * @throws MyException if Test not found
     */
    public Test findTestByName(String testName) throws MyException {
        Test test = new Test();
        for (Test anTest : allTests) {
            if (testName.equals(anTest.getTestName())) {
                test = anTest;
            }
        }
        if (!test.equals(new Test()))
            return test;
        else throw new MyException(ExceptionMessage.TEST_NOT_FOUND);
    }
}
