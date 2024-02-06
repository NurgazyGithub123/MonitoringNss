package com.example.monitoringNss.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyPeriod {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDateTime myStartHourAndDate(){
        return LocalDateTime.parse(LocalDateTime.now().minusHours(1).withMinute(0).withSecond(0).withNano(0).format(formatter), formatter);
    }

    public LocalDateTime myEndHourAndDate(){
        return LocalDateTime.parse(LocalDateTime.now().withMinute(0).withSecond(0).withNano(0).format(formatter), formatter);
    }
    public LocalDateTime startDateDaily(){
        LocalDate currentDate = LocalDate.now();
        return LocalDateTime.parse(LocalDateTime.of(currentDate, LocalTime.MIDNIGHT).minusDays(1).format(formatter), formatter);
    }

    public LocalDateTime endDateDaily(){
        LocalDate currentDate = LocalDate.now();
        return LocalDateTime.parse(LocalDateTime.of(currentDate, LocalTime.MIDNIGHT).minusSeconds(1).format(formatter), formatter);
    }
}
