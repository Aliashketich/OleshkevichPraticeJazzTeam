package com.jazzteam.model.statistic;

import com.jazzteam.model.Identifiable;

import java.util.HashMap;

public class Statistic extends Identifiable {
    private String creationDate;
    private String overallStatistic;
    private HashMap<String, String> categoryStatistic;

    public Statistic(String creationDate, String overallStatistic, HashMap<String, String> categoryStatistic) {
        this.creationDate = creationDate;
        this.overallStatistic = overallStatistic;
        this.categoryStatistic = categoryStatistic;
    }

    public Statistic() {
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOverallStatistic() {
        return overallStatistic;
    }

    public void setOverallStatistic(String overallStatistic) {
        this.overallStatistic = overallStatistic;
    }

    public HashMap<String, String> getCategoryStatistic() {
        return categoryStatistic;
    }

    public void setCategoryStatistic(HashMap<String, String> categoryStatistic) {
        this.categoryStatistic = categoryStatistic;
    }
}
