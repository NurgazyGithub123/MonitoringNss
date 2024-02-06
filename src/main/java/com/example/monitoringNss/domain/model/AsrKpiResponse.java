package com.example.monitoringNss.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AsrKpiResponse {

    String objectInstance;

    LocalDate date;

    Double asr;

    Double ner;
}
