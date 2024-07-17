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

    @Column(name = "result_time")
    LocalDateTime result_time;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "granularity_period")
    String granularity_period;

    @Column(name = "json_value", columnDefinition = "TEXT")
    String json_value;

}
