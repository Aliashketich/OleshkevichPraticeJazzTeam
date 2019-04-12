package com.jazzteam.notification;

import com.jazzteam.Identifiable;

public class Notification extends Identifiable {
    private boolean alreadySeen;
    private String dateOfCreation;
    private String fullDescription;
    private String shortDescription;
    private NotificationType type;

    public Notification(boolean alreadySeen, String dateOfCreation, String fullDescription, String shortDescription, NotificationType type) {
        this.alreadySeen = alreadySeen;
        this.dateOfCreation = dateOfCreation;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.type = type;
    }

    public Notification() {
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
}
