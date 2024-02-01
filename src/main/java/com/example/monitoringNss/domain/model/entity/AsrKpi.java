package com.example.monitoringNss.domain.model.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity

@ToString
@Table(name = "tb_asr_kpi")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrKpi extends BaseEntity{

    String objectInstance;

    LocalDate date;

    int callAttemptTimes;

    int answerTimes;

    Double sucAttempt;

    Double asr;

    Double ner;


}
