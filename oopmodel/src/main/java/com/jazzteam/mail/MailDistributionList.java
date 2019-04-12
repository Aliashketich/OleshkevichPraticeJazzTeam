package com.jazzteam.mail;

import com.jazzteam.Identifiable;

import java.util.ArrayList;

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
}
