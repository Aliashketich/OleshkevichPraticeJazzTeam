package com.jazzteam.model.mail;

import com.jazzteam.model.Identifiable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailTemplate that = (MailTemplate) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(templateText, that.templateText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, templateText);
    }

    @Override
    public String toString() {
        return "MailTemplate{" +
                "name='" + name + '\'' +
                ", templateText='" + templateText + '\'' +
                '}';
    }
}
