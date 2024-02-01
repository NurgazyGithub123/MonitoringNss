package com.example.monitoringNss.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

final public class DateFormatToLocal {

    public static LocalDateTime dateFormat(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

    public static String formatToYear(String str){
        return str.substring(0, 4);
    }

    public static String formatToWeek(String str){

        LocalDate date = LocalDate.parse(str.substring(0, 10));

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());

        return weekNumber + "";
    }


}
