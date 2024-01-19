package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VlrSummaryRepo extends JpaRepository<VlrSummary, Long> {
}
