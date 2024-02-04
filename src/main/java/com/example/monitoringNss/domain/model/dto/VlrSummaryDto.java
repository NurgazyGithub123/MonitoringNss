package com.example.monitoringNss.domain.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VlrSummaryDto {


    Long id;
    LocalDateTime startTime;
    String msxName;
    Long vlrLocal;
    Long vlrRoaming;
    Long vlrCamel;
    Long total;
    Long bitel;
    Long vlrSGs;
    LocalDate date;
    LocalTime time;
    String year;
    String week;

}
