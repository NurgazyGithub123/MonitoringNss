package com.example.monitoringNss.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_asr")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asr extends BaseEntity{


    @Column(name = "startTime", nullable = false)
    LocalDateTime startTime;

    String neName;

    String objectInstance;

    Long localSubscribers;

    Long roamingSubscribers;

    Date date;

    LocalTime time;

    int year;

    String rnc;

    String region;
}
