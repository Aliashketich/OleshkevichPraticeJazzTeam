package com.jazzteam.service;

import com.jazzteam.exception.MyException;
import com.jazzteam.model.Company;
import com.jazzteam.model.mail.MailDistributionList;
import com.jazzteam.model.mail.MailTemplate;
import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;
import com.jazzteam.model.user.ext.Auditor;
import com.jazzteam.model.user.ext.Employee;
import com.jazzteam.model.user.ext.Sysadmin;

import java.util.ArrayList;
import java.util.HashMap;

public class AuditorService {
    private static Auditor auditor;

    private AuditorService() {

    }

    /**
     * Method for adding a new Sysadmin
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
     * @param company          global company context
     * @return created Sysadmin object
     * @throws MyException if User can't be added
     */
    public static Sysadmin addSysadmin(int age, ArrayList<Notification> notifications, String email, String login, String password,
                                       String name, String surname, ArrayList<Report> reports, int experience,
                                       HashMap<Integer, String> passedTestRating, String workResultRating, Company company) throws MyException {
        Sysadmin newSysadmin = new Sysadmin(age, notifications, email, login, password, name, surname, reports, experience,
                passedTestRating, workResultRating);
        company.addUserToCompany(newSysadmin);
        return (Sysadmin) company.findUserByLogin(login);
    }

    /**
     * Method for adding a new Employee
     *
     * @param age                      age of new Employee
     * @param notifications            notifications of new Employee (must be empty for new Employee unless otherwise specified)
     * @param email                    email of new Employee
     * @param login                    login of new Employee
     * @param password                 password of new Employee
     * @param name                     name of new Employee
     * @param surname                  surname of new Employee
     * @param reports                  reports of new Employee (must be empty for new Employee unless otherwise specified)
     * @param company                  global company context
     * @param department               department of new Employee
     * @param informationSecuritySkill information security skill of new Employee
     * @param ratingsOfPassedTest      ratings of all passed tests of new Employee
     * @return created Employee object
     * @throws MyException if User can't be added
     */
    public static Employee addEmployee(int age, ArrayList<Notification> notifications, String email, String login, String password,
                                       String name, String surname, ArrayList<Report> reports, String department,
                                       String informationSecuritySkill, HashMap<Integer, String> ratingsOfPassedTest,
                                       Company company) throws MyException {
        Employee newEmployee = new Employee(age, notifications, email, login, password, name, surname, reports, department,
                informationSecuritySkill, ratingsOfPassedTest);
        company.addUserToCompany(newEmployee);
        return (Employee) company.findUserByLogin(login);
    }


    public static ArrayList<MailDistributionList> findAllMailDistributionLists() {
        return auditor.getMailDistributionLists();
    }

    /**
     * Method creating of new mail distribution list
     *
     * @param emails               email of system users
     * @param distributionListName name of mail distribution list
     * @return created mail distribution list
     */
    public static MailDistributionList addDistributionList(ArrayList<String> emails, String distributionListName) {
        MailDistributionList newDistributionList = new MailDistributionList(emails, distributionListName);
        auditor.getMailDistributionLists().add(newDistributionList);
        return newDistributionList;
    }

    public static ArrayList<MailTemplate> findAllMailTemplates() {
        return auditor.getMailTemplates();
    }

    /**
     * Creating method for new mail template
     *
     * @param templateName mail template name
     * @param templateText mail template description / text
     * @return created MailTemplate obj
     */
    public static MailTemplate addMailTemplate(String templateName, String templateText) {
        MailTemplate newMailTemplate = new MailTemplate(templateName, templateText);
        auditor.getMailTemplates().add(newMailTemplate);
        return newMailTemplate;
    }
}
