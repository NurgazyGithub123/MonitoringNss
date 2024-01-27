package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_vlrsummary_kpi")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKpi extends BaseEntity{

    String msxName;

    Long prepaid;

    Long roaming;

    Long camel;

    Long total;

    @Column(name = "postpaid", nullable = false)
    Long postpaid;

    Long vlr4g;
    @Column(nullable = false, unique = true)
    LocalDate date;

    String month;

    String year;
}
