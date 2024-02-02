package com.example.monitoringNss.domain.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AsrKpiDto {

    Long id;

    String objectInstance;

    LocalDate date;

    int callAttemptTimes;

    int answerTimes;

    Integer sucAttempt;

    Double asr;

    Double ner;
}
