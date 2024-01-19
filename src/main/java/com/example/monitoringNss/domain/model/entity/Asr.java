package com.example.monitoringNss.domain.model.entity;

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

    @Column(nullable = false, length =50)
    String neName;

    @Column(nullable = false)
    Long localSubscribers;

    Long roamingSubscribers;

    String rnc;

    String region;

}
