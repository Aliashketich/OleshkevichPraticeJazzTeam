package com.jazzteam.model.user.ext;

import com.jazzteam.model.Company;
import com.jazzteam.model.mail.MailDistributionList;
import com.jazzteam.model.mail.MailTemplate;
import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.test.Test;
import com.jazzteam.model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.jazzteam.util.date.TimeAndDateUtils.getCurrentDate;

public class Auditor extends User {
    private ArrayList<Employee> employeeList;
    private ArrayList<MailDistributionList> mailDistributionLists;
    private ArrayList<MailTemplate> mailTemplates;
    private ArrayList<Sysadmin> sysadmins;
    private ArrayList<Test> tests;
    private int experience;

    // TODO: 17.04.2019 Использование логгера для методов, чтобы отслеживать в консоли места крашей

    public Auditor(ArrayList<Employee> employeeList, ArrayList<MailDistributionList> mailDistributionLists, ArrayList<MailTemplate> mailTemplates, ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        this.employeeList = employeeList;
        this.mailDistributionLists = mailDistributionLists;
        this.mailTemplates = mailTemplates;
        this.sysadmins = sysadmins;
        this.tests = tests;
        this.experience = experience;
    }

    public Auditor(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, ArrayList<Report> reports, ArrayList<Employee> employeeList, ArrayList<MailDistributionList> mailDistributionLists, ArrayList<MailTemplate> mailTemplates, ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        super(age, notifications, email, login, password, name, surname, reports, "auditor");
        this.employeeList = employeeList;
        this.mailDistributionLists = mailDistributionLists;
        this.mailTemplates = mailTemplates;
        this.sysadmins = sysadmins;
        this.tests = tests;
        this.experience = experience;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public ArrayList<MailDistributionList> getMailDistributionLists() {
        return mailDistributionLists;
    }

    public void setMailDistributionLists(ArrayList<MailDistributionList> mailDistributionLists) {
        this.mailDistributionLists = mailDistributionLists;
    }

    public ArrayList<MailTemplate> getMailTemplates() {
        return mailTemplates;
    }

    public void setMailTemplates(ArrayList<MailTemplate> mailTemplates) {
        this.mailTemplates = mailTemplates;
    }

    public ArrayList<Sysadmin> getSysadmins() {
        return sysadmins;
    }

    public void setSysadmins(ArrayList<Sysadmin> sysadmins) {
        this.sysadmins = sysadmins;
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    /*Use-cases methods*/

    public boolean addDistributionList(ArrayList<String> emails, String distributionListName) {
        /**
         * Добавление списка рассылки из БД через обращение по id.
         */
        MailDistributionList newDistributionList = new MailDistributionList(emails, distributionListName);
        return true;
    }

    public boolean deleteDistributionList(int distributionListId) {
        /**
         * Удаление списка рассылки из БД через обращение по id.
         */
        return true;
    }

    public MailDistributionList editDistributionList(int distributionListId, String newName, ArrayList<String> newEmailsList) {
        MailDistributionList editedDistributionList = new MailDistributionList(newEmailsList, newName);
        /**
         * Вытянуть по ид запись,которую нужно изменить и изменить
         * findMailDistributionListById(int distributionListId);
         */
        return editedDistributionList;
    }

    public ArrayList<MailDistributionList> findAllDistributionList() {
        ArrayList<MailDistributionList> allDistributionList = new ArrayList<>();
        /**
         * Достать все списки рассылок из БД
         */
        return allDistributionList;
    }

    public boolean addMailTemplate(String templateName, String templateText) {
        MailTemplate newMailTemplate = new MailTemplate(templateName, templateText);
        /**
         * Метод добавления шаблона письма
         */
        return true;
    }

    public boolean deleteMailTemplate(int mailTemplateId) {
        /**
         * Реализация удаления шаблона письма из БД
         */
        return true;
    }

    public MailTemplate editMailTemplate(int mailTemplateId, String newTemplateName, String newTemplateText) {
        MailTemplate editedMailTemplate = new MailTemplate(newTemplateName, newTemplateText);
        /**
         * Изменение шаблона письма по его id
         * findMailTemplateById(int mailTemplateId);
         */
        return editedMailTemplate;
    }

    public ArrayList<MailTemplate> findAllMailTemplates() {
        /**
         * Достать все шаблоны писем из БД
         */
        return new ArrayList<>();
    }

    public boolean addEmployee(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, Report report, String role, String department, String informationSecuritySkill, HashMap<Integer, String> ratingsOfPassedTest) {
        /**
         * notifications must be empty for new Employee
         * report must be empty for new Employee
         * testResults must be empty for new Employee
         * informationSecuritySkill must be set "none" value for new Employee
         */
        return true;
    }

    /**
     * method which delete User from company context
     *
     * @param user    User object which should be deleted
     * @param company Company global Context
     */
    public void deleteUser(User user, Company company) {
        for (int i = 0; i < company.getAllUsers().size(); i++) {
            if (company.getAllUsers().get(i).equals(user) && !company.getAllUsers().get(i).getRole().equals("auditor")) {
                company.getAllUsers().remove(i);
                break;
            }
        }
    }

    /**
     * method for adding a new Sysadmin
     * user role must be set at "sysadmin"
     *
     * @param age              age of new Sysadmin
     * @param notifications    notifications of new Sysadmin (must be empty for new Sysadmin unless otherwise specified)
     * @param email            email of new Sysadmin
     * @param login            login of new Sysadmin
     * @param password         password of new Sysadmin
     * @param name             name of new Sysadmin
     * @param surname          surname of new Sysadmin
     * @param reports          reports of new Sysadmin (must be empty for new Sysadmin unless otherwise specified)
     * @param experience       experience of new Sysadmin
     * @param passedTestRating ratings of all passed sysadmin's test (must be empty for new Sysadmin unless otherwise specified)
     * @param workResultRating work result rating of new Sysadmin (must be empty for new Sysadmin unless otherwise specified)
     * @return created Sysadmin object
     */
    public Sysadmin addSysadmin(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, ArrayList<Report> reports, int experience, HashMap<Integer, String> passedTestRating, String workResultRating) {
        return new Sysadmin(age, notifications, email, login, password, name, surname, reports, experience, passedTestRating, workResultRating);
    }

    /**
     * method for editing Employee personal data
     *
     * @param employee      Employee object for editing
     * @param newAge        new Employee age
     * @param newEmail      new Employee email
     * @param newLogin      new Employee login
     * @param newPassword   new Employee password
     * @param newName       new Employee name
     * @param newSurname    new Employee surname
     * @param newDepartment new Employee department
     */
    public void changeEmployeePersonalData(Employee employee, int newAge, String newEmail, String newLogin, String newPassword, String newName, String newSurname, String newDepartment) {
        changeUserPersonalData(employee, newAge, newEmail, newLogin, newPassword, newName, newSurname);
        employee.setDepartment(newDepartment);
    }

    /**
     * method for editing User personal data
     *
     * @param user        User object for editing
     * @param newAge      new User age
     * @param newEmail    new User email
     * @param newLogin    new User login
     * @param newPassword new User password
     * @param newName     new User name
     * @param newSurname  new User surname
     */
    public void changeUserPersonalData(User user, int newAge, String newEmail, String newLogin, String newPassword, String newName, String newSurname) {
        user.setAge(newAge);
        user.setEmail(newEmail);
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setName(newName);
        user.setSurname(newSurname);
    }

    /**
     * method for editing Sysadmin personal data
     *
     * @param sysadmin      Sysadmin object for editing
     * @param newAge        new Sysadmin age
     * @param newEmail      new Sysadmin email
     * @param newLogin      new Sysadmin login
     * @param newPassword   new Sysadmin password
     * @param newName       new Sysadmin name
     * @param newSurname    new Sysadmin surname
     * @param newExperience new Sysadmin experience value
     */
    public void changeSysadminPersonalData(Sysadmin sysadmin, int newAge, String newEmail, String newLogin, String newPassword, String newName, String newSurname, int newExperience) {
        changeUserPersonalData(sysadmin, newAge, newEmail, newLogin, newPassword, newName, newSurname);
        sysadmin.setExperience(newExperience);
    }

    /**
     * method for insert Test into system
     * also method set current date into Test.dateAdd field in format "dd/MM/yyyy")
     *
     * @param testName       name of new Test
     * @param testCategory   category of new Test
     * @param testTarget     target of new Test
     * @param questions      questions of new Test
     * @param correctAnswers correct answers of new Test
     * @return created Test object
     */
    public Test addTest(String testName, String testCategory, String testTarget, HashMap<Integer, ArrayList<String>> questions, HashMap<Integer, Integer> correctAnswers) {
        return new Test(testName, testCategory, testTarget, questions, correctAnswers);
    }

    /**
     * method delete Test object
     *
     * @param test    Test object for deleting
     * @param company Company global context
     * @return true if Test deleted or false if not
     */
    public void deleteTest(Test test, Company company) {
        for (int i = 0; i < company.getAllTests().size(); i++) {
            if (company.getAllTests().get(i).equals(test)) {
                company.getAllTests().remove(i);
                break;
            }
        }
    }

    /**
     * method for editing Test
     * this method call getCurrentDate() for set current date
     * this method can not change questions hashmap
     *
     * @param test              object of Test which should be edited
     * @param newTestName       new name value for test
     * @param newTestCategory   new category value for Test
     * @param newTestTarget     new target (employee/sysadmin) for test
     * @param newCorrectAnswers new HashMap<Integer,Integer> with correct test answers
     */
    public void editTest(Test test, String newTestName, String newTestCategory, String newTestTarget, HashMap<Integer, Integer> newCorrectAnswers) {
        test.setTestName(newTestName);
        test.setCorrectAnswers(newCorrectAnswers);
        test.setDateOfLastEdit(getCurrentDate());
        test.setTestCategory(newTestCategory);
        test.setTestTarget(newTestTarget);
    }

    @Override
    public String toString() {
        return "Auditor{" +
                "employeeList=" + employeeList +
                ", mailDistributionLists=" + mailDistributionLists +
                ", mailTemplates=" + mailTemplates +
                ", sysadmins=" + sysadmins +
                ", tests=" + tests +
                ", experience=" + experience +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeList, mailDistributionLists, mailTemplates, sysadmins, tests, experience);
    }
}
