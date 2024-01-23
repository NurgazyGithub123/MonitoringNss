package com.example.monitoringNss.domain.dto.model;


import java.time.LocalDateTime;


public interface AsrDto {


    Long getId();

    LocalDateTime getStartTime();

    String getNeName();

    String getRegion();

    Long getLocalSubscribers();

}
