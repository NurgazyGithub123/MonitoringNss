package com.example.monitoringNss.domain.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateVlrSummaryRequest {

    LocalDateTime startTime;

    String msxName;

    Long vlrLocal;

    Long vlrRoaming;

    Long vlrCamel;

    Long total;

    Long vlrSGs;


}
