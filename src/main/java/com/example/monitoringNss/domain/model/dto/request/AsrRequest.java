package com.example.monitoringNss.domain.model.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrRequest {

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
