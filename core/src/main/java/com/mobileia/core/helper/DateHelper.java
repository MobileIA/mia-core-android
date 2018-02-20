package com.mobileia.core.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matiascamiletti on 20/2/18.
 */

public class DateHelper {
    /**
     * Convierte un objeto DATE en String, usando un formato especifo
     * @param day
     * @param format
     * @return
     */
    public static String dateToString(Date day, String format){
        SimpleDateFormat service = new SimpleDateFormat(format);
        return service.format(day);
    }

    /**
     * Convierte el Date en String en formato MySQL
     * @param day
     * @return
     */
    public static String dateToString(Date day){
        SimpleDateFormat service = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return service.format(day);
    }

    public static Date stringToDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            //System.err.println("Failed to parse Date due to:", e);
            return null;
        }
    }
}
