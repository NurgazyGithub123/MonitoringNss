package com.example.monitoringNss.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

final public class DateFormatToLocal {


    public static LocalDateTime dateFormatУMD(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

    public static LocalDateTime dateFormatDMY(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

    public static String formatToYearStr(String str){
        return str.substring(0, 4);
    }

    public static String formatToWeek(String str){

        LocalDate date = LocalDate.parse(str.substring(0, 10));

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());

        return weekNumber + "";
    }
    public static String strDDMMYYYYtoYYYYMMDD(String ttt){
        String year = ttt.substring(6,10);
        String mm = ttt.substring(3,5);
        String dd = ttt.substring(0,2);
        String time = ttt.substring(10,19);
        return year + "-" + mm + "-" + dd + time;
    }

    public static LocalDate lastDay(int a){
        LocalDate time = LocalDate.now();

        return time.minusDays(a);
    }



}
