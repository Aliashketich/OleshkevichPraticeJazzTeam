package com.jazzteam.report;

import com.jazzteam.Identifiable;

public class Report extends Identifiable {
    private String creationDate;
    private int idUser;
    private String reportName;
    private String rating;

    public Report(String creationDate, int idUser, String reportName, String rating) {
        this.creationDate = creationDate;
        this.idUser = idUser;
        this.reportName = reportName;
        this.rating = rating;
    }

    public Report() {
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
