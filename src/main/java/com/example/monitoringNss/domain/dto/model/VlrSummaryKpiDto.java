package com.example.monitoringNss.domain.dto.model;

import javax.persistence.Column;
import java.time.LocalDate;

public interface VlrSummaryKpiDto {

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
