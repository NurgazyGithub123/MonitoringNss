package com.example.monitoringNss.model.request;

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

    String objectInstance;

    Long localSubscribers;

    Long roamingSubscribers;
}
