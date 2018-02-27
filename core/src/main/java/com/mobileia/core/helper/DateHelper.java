package com.mobileia.core.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matiascamiletti on 20/2/18.
 */

public class DateHelper {

    /**
     * Convierte un string de fecha en otro formateado
     * @param date
     * @param inFormat
     * @param exFormat
     * @return
     */
    public static String stringToFormat(String date, String inFormat, String exFormat){
        // Convertir a Date
        Date dateConvert = stringToDate(date, inFormat);
        // Formateamos la fecha
        return dateToString(dateConvert, exFormat);
    }

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
        return dateToString(day, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Funcion que se encarga de convertir un String en Date con el formato personalizado
     * @param date
     * @param inFormat
     * @return
     */
    public static Date stringToDate(String date, String inFormat){
        // Creamos formateador
        SimpleDateFormat formatter = new SimpleDateFormat(inFormat);
        //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            //System.err.println("Failed to parse Date due to:", e);
            return null;
        }
    }

    /**
     * Funcion que se encarga de convertir un String en Date con el formato predefinido de MySQL
     * @param date
     * @return
     */
    public static Date stringToDate(String date){
        return stringToDate(date, "yyyy-MM-dd HH:mm:ss");
    }
}
