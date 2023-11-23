package com.example.monitoringNss.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;


public interface AsrDto {

    LocalDateTime getStartTime();

    String getNeName();

    String getRegion();
}
