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
@Table(name = "tb_vlrsummaryKpi")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKPI extends BaseEntity{

    LocalDateTime startTime;

    String msxName;

    Long prepaid;

    Long roaming;

    Long camel;

    Long total;

    @Column(name = "bitel", nullable = false)
    Long postpaid;

    Long vlr4g;

    LocalDate date;

    String month;

    String year;
}
