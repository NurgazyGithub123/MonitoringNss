package com.example.monitoringNss.domain.model.dto.dtos;

import java.time.LocalDate;

public interface AsrKpiDtoInterface {

    Long getId();
    String getObjectInstance();
    LocalDate getDate();
    Double getAsr();
    Double getNer();
    int getCallAttemptTimes();
    public int getAnswerTimes();
    Double getSucAttempt();



}
