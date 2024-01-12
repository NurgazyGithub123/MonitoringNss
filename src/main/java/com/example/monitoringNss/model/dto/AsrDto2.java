package com.example.monitoringNss.model.dto;

import java.time.LocalDateTime;

public interface AsrDto2 {

    Long getId();

    LocalDateTime getStartTime();

    String getNeName();

    String getRegion();

    Long getLocalSubscribers();
}
