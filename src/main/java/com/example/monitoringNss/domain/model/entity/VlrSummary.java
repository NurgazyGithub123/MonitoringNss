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

    @Column(name = "msx_name", nullable = false, length = 50)
    String msxName;

    Long vlrLocal;

    Long vlrRoaming;

    Long vlrCamel;

    Long total;

    Long bitel;

    Long vlrSGs;

    LocalDate date;

    LocalTime time;

    @Column(length = 10)
    String year;

    @Column(length = 10)
    String week;

}
