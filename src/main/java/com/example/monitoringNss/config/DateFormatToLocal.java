package com.example.monitoringNss.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatToLocal {

    public static LocalDateTime dateFormat(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }

}
