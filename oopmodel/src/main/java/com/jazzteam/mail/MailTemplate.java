package com.jazzteam.mail;

import com.jazzteam.Identifiable;

public class MailTemplate extends Identifiable {
    private String name;
    private String templateText;

    public MailTemplate(String name, String templateText) {
        this.name = name;
        this.templateText = templateText;
    }

    public MailTemplate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplateText() {
        return templateText;
    }

    public void setTemplateText(String templateText) {
        this.templateText = templateText;
    }
}
