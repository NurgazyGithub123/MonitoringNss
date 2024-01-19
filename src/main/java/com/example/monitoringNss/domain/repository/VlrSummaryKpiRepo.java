package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VlrSummaryKpiRepo extends JpaRepository<VlrSummary, Long> {
}
