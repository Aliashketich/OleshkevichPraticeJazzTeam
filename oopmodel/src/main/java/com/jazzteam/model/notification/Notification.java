package com.jazzteam.model.notification;

import com.jazzteam.model.Identifiable;

import java.util.Objects;

public class Notification extends Identifiable {
    private boolean alreadySeen;
    private String dateOfCreation;
    private String fullDescription;
    private String shortDescription;
    private NotificationType type;
    private String targetLogin;

    public Notification(boolean alreadySeen, String dateOfCreation, String fullDescription, String shortDescription, NotificationType type, String targetLogin) {
        this.alreadySeen = alreadySeen;
        this.dateOfCreation = dateOfCreation;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.type = type;
        this.targetLogin = targetLogin;
    }

    public boolean isAlreadySeen() {
        return alreadySeen;
    }

    public void setAlreadySeen(boolean alreadySeen) {
        this.alreadySeen = alreadySeen;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getTargetLogin() {
        return targetLogin;
    }

    public void setTargetLogin(String targetLogin) {
        this.targetLogin = targetLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return alreadySeen == that.alreadySeen &&
                Objects.equals(dateOfCreation, that.dateOfCreation) &&
                Objects.equals(fullDescription, that.fullDescription) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                type == that.type &&
                Objects.equals(targetLogin, that.targetLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alreadySeen, dateOfCreation, fullDescription, shortDescription, type, targetLogin);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "alreadySeen=" + alreadySeen +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", type=" + type +
                ", targetLogin='" + targetLogin + '\'' +
                '}';
    }
}
