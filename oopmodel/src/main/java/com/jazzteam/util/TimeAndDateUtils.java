package com.jazzteam.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateUtils {
    /**
     * Private constructor for block object creation
     */
    private TimeAndDateUtils() {
    }

    /**
     * Method for getting current date
     *
     * @return String current Date in format "dd/MM/yyyy"
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
}
