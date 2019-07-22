package com.jazzteam.model.user.ext;

import com.jazzteam.constants.Constant;
import com.jazzteam.exception.MyException;
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

import static com.jazzteam.util.TimeAndDateUtils.getCurrentDate;

public class Auditor extends User {
    private ArrayList<Employee> employeeList;
    private ArrayList<MailDistributionList> mailDistributionLists;
    private ArrayList<MailTemplate> mailTemplates;
    private ArrayList<Sysadmin> sysadmins;
    private ArrayList<Test> tests;
    private int experience;

    public Auditor(ArrayList<Employee> employeeList, ArrayList<MailDistributionList> mailDistributionLists,
                   ArrayList<MailTemplate> mailTemplates, ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        this.employeeList = employeeList;
        this.mailDistributionLists = mailDistributionLists;
        this.mailTemplates = mailTemplates;
        this.sysadmins = sysadmins;
        this.tests = tests;
        this.experience = experience;
    }

    public Auditor(int age, ArrayList<Notification> notifications, String email, String login, String password, String name,
                   String surname, ArrayList<Report> reports, ArrayList<Employee> employeeList,
                   ArrayList<MailDistributionList> mailDistributionLists, ArrayList<MailTemplate> mailTemplates,
                   ArrayList<Sysadmin> sysadmins, ArrayList<Test> tests, int experience) {
        super(age, notifications, email, login, password, name, surname, reports, Constant.AUDITOR_ROLE);
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
