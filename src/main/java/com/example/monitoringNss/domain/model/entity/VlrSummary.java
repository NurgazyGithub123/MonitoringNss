package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_vlrsummary")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummary extends BaseEntity{

    LocalDateTime startTime;

    String msxName;

    Long vlrLocal;

    Long vlrRoaming;

    Long vlrCamel;

    Long total;

    @Column(name = "bitel", nullable = false)
    Long bitel;

    Long vlrSGs;

    LocalDate date;

    LocalTime time;

    String year;

    String week;

}
