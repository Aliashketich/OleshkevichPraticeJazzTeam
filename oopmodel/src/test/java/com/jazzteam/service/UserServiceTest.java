package com.jazzteam.service;

import com.jazzteam.exception.MyException;
import com.jazzteam.model.Company;
import com.jazzteam.model.mail.MailDistributionList;
import com.jazzteam.model.mail.MailTemplate;
import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.statistic.Statistic;
import com.jazzteam.model.user.User;
import com.jazzteam.model.user.ext.Auditor;
import com.jazzteam.model.user.ext.Employee;
import com.jazzteam.model.user.ext.Sysadmin;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {
    private Auditor auditor;
    private Company company;
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
    private HashMap<Integer, String> userRatings = new HashMap<>();
    private ArrayList<MailDistributionList> mailDistributionLists = new ArrayList<>();
    private ArrayList<MailTemplate> mailTemplates = new ArrayList<>();
    private ArrayList<Sysadmin> sysadmins = new ArrayList<>();
    private ArrayList<com.jazzteam.model.test.Test> tests = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<Report> reports = new ArrayList<>();
    private HashMap<Integer, Integer> correctAnswers = new HashMap<>();
    private HashMap<Integer, ArrayList<String>> questions = new HashMap<>();
    private ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<com.jazzteam.model.test.Test> allTests = new ArrayList<>();
    private ArrayList<Statistic> allStatistics = new ArrayList<>();
    private ArrayList<Report> allReports = new ArrayList<>();
    private HashMap<Integer, String> ratingsOfEmployeePassedTest = new HashMap<>();


    @Before
    public void setUp() {
        allUsers.add(new Auditor(40, notifications, "audit@gmail.com", "audit", "audit",
                "auditorname", "auditorsurname", reports, employeeArrayList, mailDistributionLists,
                mailTemplates, sysadmins, tests, 10));
        allUsers.add(new Employee(35, notifications, "firstEmployee@gmail.com", "employee1",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings));
        allUsers.add(new Employee(35, notifications, "secondEmployee@gmail.com", "employee2",
                "secondEmployee", "secondEmployee", "secondEmployee", reports,
                "test", "A", userRatings));
        allUsers.add(new Sysadmin(44, notifications, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", reports, "sysadmin", 6,
                userRatings, "A"));

        allTests.add(new com.jazzteam.model.test.Test("firstTest", "sport", "employee",
                questions, correctAnswers));
        allTests.add(new com.jazzteam.model.test.Test("secondTest", "sport", "sysadmin",
                questions, correctAnswers));
        allTests.add(new com.jazzteam.model.test.Test("thirdTest", "cooking", "employee",
                questions, correctAnswers));

        allReports.add(new Report("employee1", "firstTest", "A"));
        allReports.add(new Report("employee1", "thirdTest", "C"));
        allReports.add(new Report("employee2", "firstTest", "A"));
        allReports.add(new Report("employee2", "thirdTest", "A"));
        allReports.add(new Report("sysadmin1", "secondTest", "B"));


        company = new Company(allReports, allStatistics, allTests, allUsers);
        Company.getInstance();

        auditor = (Auditor) company.getAllUsers().get(0);
        auditor.setEmployeeList(company.findAllEmployees());
        auditor.setSysadmins(company.findAllSysadmins());
        auditor.setTests(company.getAllTests());

        ratingsOfEmployeePassedTest.put(0, "A");
        ratingsOfEmployeePassedTest.put(1, "C");

        company.findAllEmployees().get(0).setRatingsOfPassedTest(ratingsOfEmployeePassedTest);
    }

    @Test
    public void changeEmployeePersonalDataTest() throws MyException {
        Employee employeeWithSetAllFields = new Employee(21, notifications, "email", "login",
                "password", "name", "surname", reports, "department",
                "A", userRatings);
        Employee expectedEditedEmployee = new Employee(22, notifications, "test", "test",
                "test", "test", "test", reports, "test",
                "A", userRatings);
        UserService.changeEmployeePersonalData(employeeWithSetAllFields, 22, "test", "test",
                "test", "test", "test", "test");
        assertEquals(expectedEditedEmployee.toString(), employeeWithSetAllFields.toString());
    }

    @Test(expected = NullPointerException.class)
    public void changeNullEmployeePersonalDataTest() throws MyException {
        UserService.changeEmployeePersonalData(null, 22, "test", "test",
                "test", "test", "test", "test");
    }

    @Test(expected = MyException.class)
    public void changeEmptyEmployeePersonalDataTest() throws MyException {
        Employee emptyEmployee = new Employee();
        UserService.changeEmployeePersonalData(emptyEmployee, 22, "test", "test",
                "test", "test", "test", "test");
    }

    @Test
    public void changeSysadminPersonalDataTest() throws MyException {
        Sysadmin sysadminWithSetAllFields = new Sysadmin(23, notifications, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", reports, "sysadmin", 5, userRatings,
                "A");
        Sysadmin expectedEditedSysAdmin = new Sysadmin(24, notifications, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", reports, "sysadmin", 6, userRatings,
                "A");
        UserService.changeSysadminPersonalData(sysadminWithSetAllFields, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
        assertEquals(expectedEditedSysAdmin.toString(), sysadminWithSetAllFields.toString());
    }

    @Test(expected = NullPointerException.class)
    public void changeNullSysadminPersonalDataTest() throws MyException {
        UserService.changeSysadminPersonalData(null, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
    }

    @Test(expected = MyException.class)
    public void changeEmptySysadminPersonalDataTest() throws MyException {
        Sysadmin emptySysadmin = new Sysadmin();
        UserService.changeSysadminPersonalData(emptySysadmin, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
    }

    @Test(expected = NullPointerException.class)
    public void changeNullUserPersonalDataTest() {
        UserService.changeUserPersonalData(null, 34, "email", "login", "newPassword",
                "newName", "newSurname");
    }

    @Test
    public void deleteUserWithCorrectValuesTest() throws MyException {
        int primaryAllUsersSize = allUsers.size();
        UserService.deleteUser(allUsers.get(3), company);
        assertEquals(primaryAllUsersSize - 1, allUsers.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteNonexistentUserTest() throws MyException {
        UserService.deleteUser(allUsers.get(4), company);
    }

    @Test(expected = MyException.class)
    public void deleteAuditorTest() throws MyException {
        UserService.deleteUser(allUsers.get(0), company);
    }

    @Test(expected = NullPointerException.class)
    public void deleteNullUserTest() throws MyException {
        UserService.deleteUser(null, company);
    }

    @Test
    public void auditorIsUserClassChildTest() {
        assertTrue(auditor instanceof User);
    }

}