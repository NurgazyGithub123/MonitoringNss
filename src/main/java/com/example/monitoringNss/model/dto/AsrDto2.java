package com.example.monitoringNss.model.dto;

import java.time.LocalDateTime;

public interface AsrDto2 {

    AsrDto2 getId();

    LocalDateTime getStartTime();

    String getNeName();

    String getRegion();

    int getLocalSubscribers();
}
