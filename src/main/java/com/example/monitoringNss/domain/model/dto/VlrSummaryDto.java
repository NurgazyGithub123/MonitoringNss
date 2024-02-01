package com.example.monitoringNss.domain.model.dto;

import java.time.LocalDate;

public interface VlrSummaryDto {

    Long getId();
    String getMsxName();

    Long getVlrLocal();

    Long getVlrRoaming();

    Long getVlrCamel();

    Long getTotal();

    Long getBitel();

    Long getVlrSGs();

    LocalDate getDate();
}
