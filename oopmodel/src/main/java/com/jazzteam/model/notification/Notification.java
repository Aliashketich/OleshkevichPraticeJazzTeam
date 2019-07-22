package com.jazzteam.model.notification;

import com.jazzteam.model.Identifiable;

import java.util.Objects;

public class Notification extends Identifiable {
    private boolean alreadySeen;
    private String dateOfCreation;
    private String description;
    private NotificationType type;
    private String idUser;

    public Notification(boolean alreadySeen, String dateOfCreation, String description, NotificationType type, String idUser) {
        this.alreadySeen = alreadySeen;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.type = type;
        this.idUser = idUser;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return alreadySeen == that.alreadySeen &&
                Objects.equals(dateOfCreation, that.dateOfCreation) &&
                Objects.equals(description, that.description) &&
                type == that.type &&
                Objects.equals(idUser, that.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alreadySeen, dateOfCreation, description, type, idUser);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "alreadySeen=" + alreadySeen +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", idUser='" + idUser + '\'' +
                '}';
    }
}
