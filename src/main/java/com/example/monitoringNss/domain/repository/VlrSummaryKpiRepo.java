package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.dto.model.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VlrSummaryKpiRepo extends JpaRepository<VlrSummaryKpi, Long> {

    @Query(value = "select * from tb_vlrsummary_kpi as tv where tv.date =:date", nativeQuery = true)
    VlrSummaryKpiDto avgDay (@Param("date") LocalDate date);

}
