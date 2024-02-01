package com.example.monitoringNss.domain.model.dto;

import java.time.LocalDate;

public interface VlrSummaryKpiDto {
    Long getId();
    String getMsxName();

    Long getPrepaid();

    Long getRoaming();

    Long getCamel();

    Long getTotal();

    Long getPostpaid();

    Long getVlr4g();

    LocalDate getDate();

    String getMonth();

    String getYear();
}
