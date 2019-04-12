package com.jazzteam.user;

import com.jazzteam.Identifiable;
import com.jazzteam.report.Report;
import com.jazzteam.notification.Notification;

import java.util.ArrayList;

public class User extends Identifiable {
    private int age;
    private ArrayList<Notification> notifications;
    private String email;
    private String login;
    private String password;
    private String name;
    private String surname;
    private Report report;
    private String role;

    public User() {
        super();
    }

    public User(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, Report report, String role) {
        super();
        this.age = age;
        this.notifications = notifications;
        this.email = email;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.report = report;
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
