package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRepo extends JpaRepository<Kpi, Long> {
}
