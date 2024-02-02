package com.example.monitoringNss.domain.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AsrDto implements Serializable {

    Long id;

    String objectInstance;

    LocalDateTime startTime;

    LocalDate date;

    LocalTime time;

    int callAttemptTimes;

    int answerTimes;

    Double answerRatio;

    int abandonBeforeRingTimes;

    int abandonAfterRingTimes;

    int ringedNoAnswerTimes;

    int userDeterminatedBusyTimes;

    int userBusyTimes;

    int invalidAddressTimes;

    int pagingNoResponseTimes;

    int absentSubscriberTimes;

    int subscriberServiceRestrictedTimes;

    int specialSignalTonePlayedTimes;

    int theCalledNoRespond;

    Double asr;

    Double ner;

    Integer sucAttempt;
}
