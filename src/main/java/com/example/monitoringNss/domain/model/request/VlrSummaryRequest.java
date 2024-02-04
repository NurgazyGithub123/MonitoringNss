package com.example.monitoringNss.domain.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryRequest {

    String startTime;

    String msxName;

    Long vlrLocal;

    Long vlrRoaming;

    Long vlrCamel;

    Long total;

    Long vlrSGs;


}
