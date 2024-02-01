package com.example.monitoringNss.domain.model.dto;

import java.time.LocalDate;

public interface AsrKpiDto {

    Long getId();
    String getObjectInstance();
    LocalDate getDate();
    Double getAsr();
    Double getNer();
    int getCallAttemptTimes();
    public int getAnswerTimes();
    Double getSucAttempt();



}
