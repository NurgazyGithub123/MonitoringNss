package com.example.monitoringNss.domain.repository;


import com.example.monitoringNss.domain.model.entity.Asr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsrRepo extends JpaRepository<Asr, Long> {

}
