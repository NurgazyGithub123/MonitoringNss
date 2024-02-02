package com.example.monitoringNss.domain.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAsrRequest {

    String objectInstance;

    LocalDateTime startTime;

    int callAttemptTimes;

    int answerTimes;

    Double answerRatio;

    int abandonBeforeRingTimes;

    int abandonAfterRingTimes;

    int ringedNoAnswerTimes;

    int userDeterminatedBusyTimes;

    int UserBusyTimes;

    int invalidAddressTimes;

    int pagingNoResponseTimes;

    int absentSubscriberTimes;

    int subscriberServiceRestrictedTimes;

    int specialSignalTonePlayedTimes;

    int theCalledNoRespond;
}
