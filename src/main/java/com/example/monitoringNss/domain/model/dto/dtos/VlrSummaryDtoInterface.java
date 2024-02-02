package com.example.monitoringNss.domain.model.dto.dtos;

import java.time.LocalDate;

public interface VlrSummaryDtoInterface {

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
