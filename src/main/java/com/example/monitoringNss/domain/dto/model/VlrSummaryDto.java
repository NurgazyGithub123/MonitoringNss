package com.example.monitoringNss.domain.dto.model;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface VlrSummaryDto {

    String getMsxName();

    Long getvlrLocal();

    Long getvlrRoaming();

    Long getVlrCamel();

    Long getTotal();

    Long getBitel();

    Long getVlrSGs();

    LocalDate getDate();
}
