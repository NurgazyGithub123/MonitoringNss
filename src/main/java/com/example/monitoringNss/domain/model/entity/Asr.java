package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_asr")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asr extends BaseEntity{


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
