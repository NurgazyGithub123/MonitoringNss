package com.example.monitoringNss.domain.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VlrSummaryKpiDto {

    Long id;
    String msxName;
    Long prepaid;
    Long roaming;
    Long camel;
    Long total;
    Long postpaid;
    Long vlr4g;
    LocalDate date;
    String month;
    String year;
    String week;
}
