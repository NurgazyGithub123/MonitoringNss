package com.example.monitoringNss.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Builder
@Table(name = "tb_test_class")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonAutoDetect
public class TestClassEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "TIMESTAMP ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String counterName;

    String counterValues;

    LocalDateTime startTime;


}
