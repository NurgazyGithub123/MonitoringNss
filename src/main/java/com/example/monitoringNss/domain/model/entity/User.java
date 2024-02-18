package com.example.monitoringNss.domain.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
//@Entity
@Builder
@ToString
@Table(name = "tb_user", schema = "register_details")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "seq_id", sequenceName = "seq_user", initialValue = 10, allocationSize = 1)
public class User{


    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    Long id;

    @CreationTimestamp
    @Column(name = "date_created", updatable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    LocalDateTime dateUpdated;

    @Column(name = "username", updatable = false, nullable = true, unique = true)
    String username;

    String password;

//    @PrePersist
//    private void preCreated(){
//        dateCreated = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    private void preUpdated(){
//        dateUpdated = LocalDateTime.now();
//    }





}
