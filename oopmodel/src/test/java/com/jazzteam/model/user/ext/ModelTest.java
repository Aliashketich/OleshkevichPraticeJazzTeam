package com.jazzteam.model.user.ext;

import com.jazzteam.model.Company;
import com.jazzteam.model.mail.MailDistributionList;
import com.jazzteam.model.mail.MailTemplate;
import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.statistic.Statistic;
import com.jazzteam.model.user.User;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModelTest {
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


    @Before
    public void setUp() {
        allUsers.add(new Auditor(40, notifications, "audit@gmail.com", "audit", "audit", "auditorname", "auditorsurname", reports, employeeArrayList, mailDistributionLists, mailTemplates, sysadmins, tests, 10));
        allUsers.add(new Employee(35, notifications, "firstEmployee@gmail.com", "employee1", "firstEmployee", "firstEmployee", "firstEmployee", reports, "employee", "test", "B", userRatings));
        allUsers.add(new Employee(35, notifications, "secondEmployee@gmail.com", "employee2", "secondEmployee", "secondEmployee", "secondEmployee", reports, "employee", "test", "A", userRatings));
        allUsers.add(new Sysadmin(44, notifications, "sysadmin@gmail.com", "sysadmin", "sysadmin", "sysname", "syssurname", reports, "sysadmin", 6, userRatings, "A"));

        allTests.add(new com.jazzteam.model.test.Test("firstTest", "sport", "employee", questions, correctAnswers));
        allTests.add(new com.jazzteam.model.test.Test("secondTest", "sport", "sysadmin", questions, correctAnswers));
        allTests.add(new com.jazzteam.model.test.Test("thirdTest", "cooking", "employee", questions, correctAnswers));

        allReports.add(new Report("employee1", "firstTest", "A"));
        allReports.add(new Report("employee1", "thirdTest", "C"));
        allReports.add(new Report("employee2", "firstTest", "A"));
        allReports.add(new Report("employee2", "thirdTest", "A"));
        allReports.add(new Report("sysadmin1", "secondTest", "B"));


        company = new Company(allReports, allStatistics, allTests, allUsers);

        auditor = (Auditor) company.getAllUsers().get(0);
        auditor.setEmployeeList(company.findAllEmployees());
        auditor.setSysadmins(company.findAllSysadmins());
        auditor.setTests(company.getAllTests());

        HashMap<Integer, String> ratingsOfPassedTest = new HashMap<>();
        ratingsOfPassedTest.put(0, "A");
        ratingsOfPassedTest.put(1, "C");

        company.findAllEmployees().get(0).setRatingsOfPassedTest(ratingsOfPassedTest);
    }

    @Test
    public void auditorIsUserClassObjectTest() {
        assertTrue(auditor instanceof User);
    }

    @Test
    public void changeEmployeePersonalDataTest() {
        Employee employeeWithSetAllFields = new Employee(21, notifications, "email", "login", "password", "name", "surname", reports, "employee", "department", "A", userRatings);
        Employee expectedEditedEmployee = new Employee(22, notifications, "test", "test", "test", "test", "test", reports, "employee", "test", "A", userRatings);
        auditor.changeEmployeePersonalData(employeeWithSetAllFields, 22, "test", "test", "test", "test", "test", "test");
        assertEquals(expectedEditedEmployee.toString(), employeeWithSetAllFields.toString());
    }

    @Test
    public void changeSysadminPersonalDataTest() {
        Sysadmin sysadminWithSetAllFields = new Sysadmin(23, notifications, "sysadmin@gmail.com", "sysadmin", "sysadmin", "sysname", "syssurname", reports, "sysadmin", 5, userRatings, "A");
        Sysadmin expectedEditedSysAdmin = new Sysadmin(24, notifications, "sysadmin@gmail.com", "sysadmin", "sysadmin", "sysname", "syssurname", reports, "sysadmin", 6, userRatings, "A");
        auditor.changeSysadminPersonalData(sysadminWithSetAllFields, 24, "sysadmin@gmail.com", "sysadmin", "sysadmin", "sysname", "syssurname", 6);
        assertEquals(expectedEditedSysAdmin.toString(), sysadminWithSetAllFields.toString());
    }

    @Test
    public void editTestTest() {
        com.jazzteam.model.test.Test test = allTests.get(0);
        auditor.editTest(test, "editedName", "walk", "employee", correctAnswers);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        allTests.get(0).setDateOfLastEdit(currentDate);

        assertEquals(allTests.get(0).toString(), allTests.get(0).toString());
    }

    @Test
    public void addTestTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        String toStringExpectedAddedTest = "Test{testName='firstTest', testCategory='sport', dateAdd='" + currentDate + "', dateOfLastEdit='none', testTarget='employee', questions={}, correctAnswers={}}";
        assertEquals(toStringExpectedAddedTest, auditor.addTest("firstTest", "sport", "employee", questions, correctAnswers).toString());
    }

    @Test
    public void addSysadminTest() {
        Sysadmin expectedSysadmin = new Sysadmin(35, notifications, "sysemail", "sysadmin", "syspassword", "sysname", "syssurname", reports, "sysadmin", 10, userRatings, "A");
        Sysadmin actualSysadmin = auditor.addSysadmin(35, notifications, "sysemail", "sysadmin", "syspassword", "sysname", "syssurname", reports, 10, userRatings, "A");
        assertEquals(expectedSysadmin, actualSysadmin);
    }


    @Test
    public void deleteTestTest() {
        int primaryAllTestsSize = allTests.size();
        auditor.deleteTest(allTests.get(1), company);
        assertEquals(primaryAllTestsSize - 1, allTests.size());
    }

    @Test
    public void setInformationSecuritySkillOfEmployeeTest() {
        company.calcInformationSecuritySkillOfEmployee(company.findAllEmployees().get(0));
        assertEquals("B", company.findAllEmployees().get(0).getInformationSecuritySkill());
    }

    @Test
    public void deleteUserTest() {
        int primaryAllUsersSize = allUsers.size();
        auditor.deleteUser(allUsers.get(1), company);
        assertEquals(primaryAllUsersSize - 1, allUsers.size());
    }

    @Test
    public void deleteAuditorTest() {
        int primaryAllUsersSize = allUsers.size();
        auditor.deleteUser(allUsers.get(0), company);
        assertEquals(primaryAllUsersSize, allUsers.size());
    }
}