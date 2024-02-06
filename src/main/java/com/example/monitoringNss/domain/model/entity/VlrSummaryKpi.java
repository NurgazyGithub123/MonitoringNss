package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_vlrsummary_kpi")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKpi{

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "TIMESTAMP ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "msx_name")
    String msxName;

    Long prepaid;

    Long roaming;

    Long camel;

    Long total;

    @Column(name = "postpaid")
    Long postpaid;

    Long vlr4g;

    LocalDate date;

    String month;

    String year;

    String week;
}
