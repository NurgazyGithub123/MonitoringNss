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
@Builder
@ToString
@Table(name = "tb_asr_kpi")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrKpi{

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "TIMESTAMP ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String objectInstance;

    LocalDate date;

    int callAttemptTimes;

    int answerTimes;

    Integer sucAttempt;

    Double asr;

    Double ner;


}
