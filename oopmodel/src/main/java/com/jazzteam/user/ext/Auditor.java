package com.jazzteam.user.ext;

import com.jazzteam.mail.MailDistributionList;
import com.jazzteam.mail.MailTemplate;
import com.jazzteam.notification.Notification;
import com.jazzteam.report.Report;
import com.jazzteam.test.Test;
import com.jazzteam.user.User;

import java.util.ArrayList;

public class Auditor extends User {
    private ArrayList<Employee> employeeList;
    private ArrayList<MailDistributionList> mailDistributionLists;
    private ArrayList<MailTemplate> mailTemplates;
    private ArrayList<Sysadmin> sysadmins;
    private ArrayList<Test> tests;
    private int experience;

    public Auditor(ArrayList<Employee> employeeList, ArrayList<MailDistributionList> mailDistributionLists, ArrayList<MailTemplate> mailTemplates, ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        this.employeeList = employeeList;
        this.mailDistributionLists = mailDistributionLists;
        this.mailTemplates = mailTemplates;
        this.sysadmins = sysadmins;
        this.tests = tests;
        this.experience = experience;
    }

    public Auditor(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, Report report, String role, ArrayList<Employee> employeeList, ArrayList<MailDistributionList> mailDistributionLists, ArrayList<MailTemplate> mailTemplates, ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        super(age, notifications, email, login, password, name, surname, report, role);
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


    public void addDistributionList() {
        //Реализация метода добавления списка рассылки
    }

    public void addMailTemplate() {

    }
}
