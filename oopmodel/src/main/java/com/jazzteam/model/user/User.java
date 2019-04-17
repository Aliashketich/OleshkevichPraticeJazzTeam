package com.jazzteam.model.user;

import com.jazzteam.model.Identifiable;
import com.jazzteam.model.notification.Notification;
import com.jazzteam.model.report.Report;

import java.util.ArrayList;
import java.util.Objects;

public class User extends Identifiable {
    private int age;
    private ArrayList<Notification> notifications;
    private String email;
    private String login;
    private String password;
    private String name;
    private String surname;
    private ArrayList<Report> reports;
    private String role;

    public User() {
        super();
    }

    public User(int age, ArrayList<Notification> notifications, String email, String login, String password, String name, String surname, ArrayList<Report> reports, String role) {
        super();
        this.age = age;
        this.notifications = notifications;
        this.email = email;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.reports = reports;
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

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(notifications, user.notifications) &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(reports, user.reports) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, notifications, email, login, password, name, surname, reports, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", notifications=" + notifications +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", reports=" + reports +
                ", role='" + role + '\'' +
                '}';
    }
}
