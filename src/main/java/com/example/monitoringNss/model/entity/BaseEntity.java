package com.example.monitoringNss.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "date_created", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    LocalDateTime dateUpdated;

    @PrePersist
    private void onCreated(){
        dateCreated = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdated(){
        dateUpdated = LocalDateTime.now();
    }


}
