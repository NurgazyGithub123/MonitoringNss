package com.example.monitoringNss.domain.dto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface AsrKpiDto {

    String getObjectInstance();

    LocalDate getDate();


    Double getAsr();

    Double getNer();
}
