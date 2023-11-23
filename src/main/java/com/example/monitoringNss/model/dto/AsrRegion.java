package com.example.monitoringNss.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


public interface AsrRegion {

    LocalDateTime getStartTime();

    String getNeName();

    Long getLocalSubscribers();

    Long getRoamingSubscribers();

    String getRnc();

    String getRegion();
}
