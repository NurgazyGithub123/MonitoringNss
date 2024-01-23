package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VlrSummaryKpiRepo extends JpaRepository<VlrSummaryKPI, Long> {
}
