package com.example.monitoringNss.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_asr")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asr extends BaseEntity{


    @Column(nullable = false)
    LocalDateTime startTime;

    String neName;

    Long localSubscribers;

    Long roamingSubscribers;

    String rnc;

    String region;

}
