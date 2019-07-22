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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestBusinessTest {
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
    public void deleteTestTest() throws MyException {
        int primaryAllTestsSize = allTests.size();
        TestService.deleteTest(allTests.get(1), company);
        assertEquals(primaryAllTestsSize - 1, allTests.size());
    }

    @Test(expected = NullPointerException.class)
    public void deleteNullTestTest() throws MyException {
        TestService.deleteTest(null, company);
    }

    @Test(expected = MyException.class)
    public void deleteEmptyTestTest() throws MyException {
        com.jazzteam.model.test.Test emptyTest = new com.jazzteam.model.test.Test();
        TestService.deleteTest(emptyTest, company);
    }

    @Test
    public void addTestTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        TestService.addTest("ttest", "sport", "employee",
                questions, correctAnswers, company);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    @Test(expected = MyException.class)
    public void addTestWithAlreadyExistNameTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        TestService.addTest("firstTest", "sport", "employee",
                questions, correctAnswers, company);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    @Test(expected = NullPointerException.class)
    public void addTestToNullCompanyTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        TestService.addTest("ttest", "sport", "employee",
                questions, correctAnswers, null);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    @Test
    public void editTestTest() {
        com.jazzteam.model.test.Test test = allTests.get(0);
        TestService.editTest(test, "editedName", "walk", "employee", correctAnswers);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        allTests.get(0).setDateOfLastEdit(currentDate);
        assertEquals(allTests.get(0).toString(), allTests.get(0).toString());
    }
}