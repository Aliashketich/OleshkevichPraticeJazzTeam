package com.jazzteam.model.mail;

import com.jazzteam.model.Identifiable;

import java.util.ArrayList;
import java.util.Objects;

public class MailDistributionList extends Identifiable {
    private ArrayList<String> emails;
    private String name;

    public MailDistributionList(ArrayList<String> emails, String name) {
        this.emails = emails;
        this.name = name;
    }

    public MailDistributionList() {
    }


    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailDistributionList that = (MailDistributionList) o;
        return Objects.equals(emails, that.emails) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emails, name);
    }

    @Override
    public String toString() {
        return "MailDistributionList{" +
                "emails=" + emails +
                ", name='" + name + '\'' +
                '}';
    }
}
