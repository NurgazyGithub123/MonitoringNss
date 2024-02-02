package com.example.monitoringNss.domain.model.dto.dtos;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public interface AsrDtoInterface {

    Long getId();

    String getObjectInstance();

    LocalDateTime getStartTime();

    LocalDate getDate();

    LocalTime getTime();

    int getCallAttemptTimes();

    int getAnswerTimes();

    Double getAnswerRatio();

    int getAbandonBeforeRingTimes();

    int getAbandonAfterRingTimes();

    int getRingedNoAnswerTimes();

    int getUserDeterminatedBusyTimes();

    int getUserBusyTimes();

    int getInvalidAddressTimes();

    int getPagingNoResponseTimes();

    int getAbsentSubscriberTimes();

    int getSubscriberServiceRestrictedTimes();

    int getSpecialSignalTonePlayedTimes();

    int getTheCalledNoRespond();

    Integer getSucAttempt();


}
