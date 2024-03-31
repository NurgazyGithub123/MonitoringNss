package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Builder
@Table(name = "kpi")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Kpi {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "TIMESTAMP ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime result_time;

    String fileName;

    String granularity_period;

    String counterName;

    String json_value;
}
