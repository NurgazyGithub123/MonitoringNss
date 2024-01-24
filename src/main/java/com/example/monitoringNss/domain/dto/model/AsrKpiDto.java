package com.example.monitoringNss.domain.dto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface AsrKpiDto {

    Long getId();

    String getObjectInstance();

    LocalDateTime getStartTime();

    LocalDate getDate();

    LocalTime getTime();

    Double getSucAttempt();

    Double getAsr();

    Double getNer();
}
