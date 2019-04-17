package com.jazzteam.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateUtils {
    /**
     * method for getting current date
     *
     * @return String current Date in format "dd/MM/yyyy"
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
}
