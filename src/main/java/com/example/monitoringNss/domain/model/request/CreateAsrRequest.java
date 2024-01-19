package com.example.monitoringNss.domain.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAsrRequest {

    LocalDateTime startTime;

    String neName;

    String rnc;

    String region;

    Long localSubscribers;

    Long roamingSubscribers;
}
