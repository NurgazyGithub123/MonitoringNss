package com.example.monitoringNss.model.dto;

import java.time.LocalDateTime;

public interface AsrRegionRepoDto {

    LocalDateTime getStartTime();

    String getNe_Name();

    Long getLocalSubscribers();

    Long getRoamingSubscribers();

    String getRnc();

    String getRegion();
}
