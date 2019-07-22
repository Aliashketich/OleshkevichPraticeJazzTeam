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

public class AuditorServiceTest {
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
    public void addSysadminTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        AuditorService.addSysadmin(35, notifications, "sysemail", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = MyException.class)
    public void addSysadminWithAlreadyExistLoginTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        AuditorService.addSysadmin(35, notifications, "sysemail", "sysadmin", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = NullPointerException.class)
    public void addSysadminToNullCompanyTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        AuditorService.addSysadmin(35, notifications, "sysemail", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", null);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = MyException.class)
    public void addSysadminWithAlreadyExistEmailTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        AuditorService.addSysadmin(35, notifications, "sysadmin@gmail.com", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    /*Auditor addEmployee tests*/
    @Test
    public void addEmployeeTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        AuditorService.addEmployee(35, notifications, "egorEmployee@gmail.com", "employee egor",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = MyException.class)
    public void addEmployeeWithAlreadyExistLoginTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        AuditorService.addEmployee(35, notifications, "firstEmploe@gmail.com", "employee1",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = MyException.class)
    public void addEmployeeWithAlreadyExistEmailTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        AuditorService.addEmployee(35, notifications, "firstEmployee@gmail.com", "employ",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = NullPointerException.class)
    public void addEmployeeToNullCompanyTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        AuditorService.addEmployee(35, notifications, "filoyee@gmail.com", "employ",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, null);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }


}