package com.jazzteam.model.user.ext;

import com.jazzteam.exception.MyException;
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

import static org.junit.Assert.*;

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
    public void auditorIsUserClassChildTest() {
        assertTrue(auditor instanceof User);
    }

    /*Auditor edit personal data tests*/
    @Test
    public void changeEmployeePersonalDataTest() throws MyException {
        Employee employeeWithSetAllFields = new Employee(21, notifications, "email", "login",
                "password", "name", "surname", reports, "department",
                "A", userRatings);
        Employee expectedEditedEmployee = new Employee(22, notifications, "test", "test",
                "test", "test", "test", reports, "test",
                "A", userRatings);
        auditor.changeEmployeePersonalData(employeeWithSetAllFields, 22, "test", "test",
                "test", "test", "test", "test");
        assertEquals(expectedEditedEmployee.toString(), employeeWithSetAllFields.toString());
    }

    @Test(expected = NullPointerException.class)
    public void changeNullEmployeePersonalDataTest() throws MyException {
        auditor.changeEmployeePersonalData(null, 22, "test", "test",
                "test", "test", "test", "test");
    }

    @Test(expected = MyException.class)
    public void changeEmptyEmployeePersonalDataTest() throws MyException {
        Employee emptyEmployee = new Employee();
        auditor.changeEmployeePersonalData(emptyEmployee, 22, "test", "test",
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
        auditor.changeSysadminPersonalData(sysadminWithSetAllFields, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
        assertEquals(expectedEditedSysAdmin.toString(), sysadminWithSetAllFields.toString());
    }

    @Test(expected = NullPointerException.class)
    public void changeNullSysadminPersonalDataTest() throws MyException {
        auditor.changeSysadminPersonalData(null, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
    }

    @Test(expected = MyException.class)
    public void changeEmptySysadminPersonalDataTest() throws MyException {
        Sysadmin emptySysadmin = new Sysadmin();
        auditor.changeSysadminPersonalData(emptySysadmin, 24, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", 6);
    }

    @Test(expected = NullPointerException.class)
    public void changeNullUserPersonalDataTest() {
        auditor.changeUserPersonalData(null, 34, "email", "login", "newPassword",
                "newName", "newSurname");
    }

    /*Auditor deleteUser tests*/
    @Test
    public void deleteUserWithCorrectValuesTest() throws MyException {
        int primaryAllUsersSize = allUsers.size();
        auditor.deleteUser(allUsers.get(3), company);
        assertEquals(primaryAllUsersSize - 1, allUsers.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteNonexistentUserTest() throws MyException {
        auditor.deleteUser(allUsers.get(4), company);
    }

    @Test(expected = MyException.class)
    public void deleteAuditorTest() throws MyException {
        auditor.deleteUser(allUsers.get(0), company);
    }

    @Test(expected = NullPointerException.class)
    public void deleteNullUserTest() throws MyException {
        auditor.deleteUser(null, company);
    }

    /*Company calcInformationSecuritySkillOfEmployee tests*/
    @Test
    public void calcInformationSecuritySkillOfEmployeeTest() throws MyException {
        assertEquals("B", company.calcInformationSecuritySkillOfEmployee(company.findAllEmployees().get(0)));
    }

    @Test(expected = MyException.class)
    public void calcInformationSecuritySkillOfNullEmployeeTest() throws MyException {
        assertEquals("Employee is null", company.calcInformationSecuritySkillOfEmployee(null));
    }

    @Test(expected = MyException.class)
    public void calcInformationSecuritySkillOfNullRatingsEmployeeTest() throws MyException {
        Employee employeeWithNullRatings = new Employee();
        assertEquals("Ratings is null", company.calcInformationSecuritySkillOfEmployee(employeeWithNullRatings));
    }

    @Test(expected = MyException.class)
    public void calcInformationSecuritySkillOfEmptyRatingsEmployeeTest() throws MyException {
        Employee employeeWithEmptyRatings = new Employee();
        ratingsOfEmployeePassedTest.put(0, "");
        ratingsOfEmployeePassedTest.put(1, "");
        employeeWithEmptyRatings.setRatingsOfPassedTest(ratingsOfEmployeePassedTest);
        assertEquals("Incorrect values into Ratings. Value is not 'A/B/C/D/E'",
                company.calcInformationSecuritySkillOfEmployee(employeeWithEmptyRatings));
    }

    /*Auditor deleteTest tests*/
    @Test
    public void deleteTestTest() throws MyException {
        int primaryAllTestsSize = allTests.size();
        auditor.deleteTest(allTests.get(1), company);
        assertEquals(primaryAllTestsSize - 1, allTests.size());
    }

    @Test(expected = NullPointerException.class)
    public void deleteNullTestTest() throws MyException {
        auditor.deleteTest(null, company);
    }

    @Test(expected = MyException.class)
    public void deleteEmptyTestTest() throws MyException {
        com.jazzteam.model.test.Test emptyTest = new com.jazzteam.model.test.Test();
        auditor.deleteTest(emptyTest, company);
    }

    /*Auditor addSysadmin tests*/
    @Test
    public void addSysadminTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        auditor.addSysadmin(35, notifications, "sysemail", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = MyException.class)
    public void addSysadminWithAlreadyExistLoginTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        auditor.addSysadmin(35, notifications, "sysemail", "sysadmin", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = NullPointerException.class)
    public void addSysadminToNullCompanyTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        auditor.addSysadmin(35, notifications, "sysemail", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", null);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    @Test(expected = MyException.class)
    public void addSysadminWithAlreadyExistEmailTest() throws MyException {
        int primaryNumberOfSysadmins = company.findAllSysadmins().size();
        auditor.addSysadmin(35, notifications, "sysadmin@gmail.com", "sysadmin2", "syspassword",
                "sysname", "syssurname", reports, 10, userRatings, "A", company);
        assertEquals(primaryNumberOfSysadmins + 1, company.findAllSysadmins().size());
    }

    /*Auditor addEmployee tests*/
    @Test
    public void addEmployeeTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        auditor.addEmployee(35, notifications, "egorEmployee@gmail.com", "employee egor",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = MyException.class)
    public void addEmployeeWithAlreadyExistLoginTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        auditor.addEmployee(35, notifications, "firstEmploe@gmail.com", "employee1",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = MyException.class)
    public void addEmployeeWithAlreadyExistEmailTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        auditor.addEmployee(35, notifications, "firstEmployee@gmail.com", "employ",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, company);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    @Test(expected = NullPointerException.class)
    public void addEmployeeToNullCompanyTest() throws MyException {
        int primaryNumberOfEmployee = company.findAllEmployees().size();
        auditor.addEmployee(35, notifications, "filoyee@gmail.com", "employ",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings, null);
        assertEquals(primaryNumberOfEmployee + 1, company.findAllEmployees().size());
    }

    /*Auditor addTest tests*/
    @Test
    public void addTestTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        auditor.addTest("ttest", "sport", "employee",
                questions, correctAnswers, company);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    @Test(expected = MyException.class)
    public void addTestWithAlreadyExistNameTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        auditor.addTest("firstTest", "sport", "employee",
                questions, correctAnswers, company);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    @Test(expected = NullPointerException.class)
    public void addTestToNullCompanyTest() throws MyException {
        int primaryNumberOfTests = company.getAllTests().size();
        auditor.addTest("ttest", "sport", "employee",
                questions, correctAnswers, null);
        assertEquals(primaryNumberOfTests + 1, company.getAllTests().size());
    }

    /*Auditor editTest tests*/
    @Test
    public void editTestTest() {
        com.jazzteam.model.test.Test test = allTests.get(0);
        auditor.editTest(test, "editedName", "walk", "employee", correctAnswers);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        allTests.get(0).setDateOfLastEdit(currentDate);
        assertEquals(allTests.get(0).toString(), allTests.get(0).toString());
    }

    /*Company findAllEmployees tests*/
    @Test
    public void findAllEmployeesListTest() {
        ArrayList<Employee> actualEmployeesList = company.findAllEmployees();
        ArrayList<Employee> expectedEmployeeList = new ArrayList<>();
        expectedEmployeeList.add(new Employee(35, notifications, "firstEmployee@gmail.com", "employee1",
                "firstEmployee", "firstEmployee", "firstEmployee", reports, "test",
                "B", userRatings));
        expectedEmployeeList.add(new Employee(35, notifications, "secondEmployee@gmail.com", "employee2",
                "secondEmployee", "secondEmployee", "secondEmployee", reports, "test",
                "A", userRatings));
        assertArrayEquals(expectedEmployeeList.toArray(), actualEmployeesList.toArray());
    }

    /*Company findAllSysadmins tests*/
    @Test
    public void findAllSysadminsListTest() {
        ArrayList<Sysadmin> actualSysadminList = company.findAllSysadmins();
        ArrayList<Sysadmin> expectedSysadminList = new ArrayList<>();
        expectedSysadminList.add(new Sysadmin(44, notifications, "sysadmin@gmail.com", "sysadmin",
                "sysadmin", "sysname", "syssurname", reports, "sysadmin", 6,
                userRatings, "A"));
        assertArrayEquals(expectedSysadminList.toArray(), actualSysadminList.toArray());
    }

    /*Company findUserByLogin tests*/
    @Test
    public void findUserByLoginTest() throws MyException {
        assertEquals(allUsers.get(1), company.findUserByLogin("employee1"));
    }

    @Test(expected = MyException.class)
    public void findNonexistentUserByLoginTest() throws MyException {
        company.findUserByLogin("logggiiiinn");
    }

    @Test(expected = NullPointerException.class)
    public void findNullUserByLoginTest() throws MyException {
        company.findUserByLogin(null);
    }

    /*Company findTestByTestName tests*/
    @Test
    public void findTestByTestNameTest() throws MyException {
        assertEquals(allTests.get(0), company.findTestByName("firstTest"));
    }

    @Test(expected = MyException.class)
    public void findNonexistentTestByTestNameTest() throws MyException {
        company.findTestByName("teertwrtwrtw");
    }

    @Test(expected = NullPointerException.class)
    public void findNullTestByTestNameTest() throws MyException {
        company.findTestByName(null);
    }

    /*Company addUserToCompany tests*/
    @Test
    public void addUserToCompanyTest() throws MyException {
        User user = new Employee(35, notifications, "thirdEmployee@gmail.com", "employee3",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings);
        int primaryNumberOfUsers = allUsers.size();
        company.addUserToCompany(user);
        assertEquals(primaryNumberOfUsers + 1, allUsers.size());
    }

    @Test(expected = MyException.class)
    public void addUserWithAlreadyExistLoginTest() throws MyException {
        User user = new Employee(35, notifications, "thirdEmployee@gmail.com", "employee1",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings);
        int primaryNumberOfUsers = allUsers.size();
        company.addUserToCompany(user);
        assertEquals(primaryNumberOfUsers + 1, allUsers.size());
    }

    @Test(expected = MyException.class)
    public void addUserWithAlreadyExistEmailTest() throws MyException {
        User user = new Employee(35, notifications, "secondEmployee@gmail.com", "employee4",
                "firstEmployee", "firstEmployee", "firstEmployee", reports,
                "test", "B", userRatings);
        int primaryNumberOfUsers = allUsers.size();
        company.addUserToCompany(user);
        assertEquals(primaryNumberOfUsers + 1, allUsers.size());
    }

    @Test(expected = MyException.class)
    public void addEmptyUserToCompanyTest() throws MyException {
        User user = new User();
        int primaryNumberOfUsers = allUsers.size();
        company.addUserToCompany(user);
        assertEquals(primaryNumberOfUsers + 1, allUsers.size());
    }

    @Test(expected = NullPointerException.class)
    public void addNullUserToCompanyTest() throws MyException {
        int primaryNumberOfUsers = allUsers.size();
        company.addUserToCompany(null);
        assertEquals(primaryNumberOfUsers + 1, allUsers.size());
    }

    /*Company addTestToCompany tests*/
    @Test
    public void addTestToCompanyTest() throws MyException {
        com.jazzteam.model.test.Test test = new com.jazzteam.model.test.Test("tryTest", "sport",
                "employee", questions, correctAnswers);
        int primaryTestNumber = allTests.size();
        company.addTestToCompany(test);
        assertEquals(primaryTestNumber + 1, allTests.size());
    }

    @Test(expected = MyException.class)
    public void addEmptyTestToCompanyTest() throws MyException {
        com.jazzteam.model.test.Test emptyTest = new com.jazzteam.model.test.Test();
        int primaryTestNumber = allTests.size();
        company.addTestToCompany(emptyTest);
        assertEquals(primaryTestNumber + 1, allTests.size());
    }

    @Test(expected = NullPointerException.class)
    public void addNullTestToCompanyTest() throws MyException {
        int primaryTestNumber = allTests.size();
        company.addTestToCompany(null);
        assertEquals(primaryTestNumber + 1, allTests.size());
    }

    @Test(expected = MyException.class)
    public void addTestWithAlreadyExistNameToCompanyTest() throws MyException {
        com.jazzteam.model.test.Test test = new com.jazzteam.model.test.Test("firstTest", "sport",
                "employee", questions, correctAnswers);
        int primaryTestNumber = allTests.size();
        company.addTestToCompany(test);
        assertEquals(primaryTestNumber + 1, allTests.size());
    }
}