package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VlrSummaryKpiRepo extends JpaRepository<VlrSummaryKpi, Long> {

    @Query(value = "select tv.msx_name as msxName, tv.date, tv.postpaid, tv.prepaid,tv.roaming, " +
            "tv.camel, tv.total, tv.vlr4g, tv.month, tv.year  from tb_vlrsummary_kpi as tv where tv.date =:date", nativeQuery = true)
    VlrSummaryKpiDto avgDay (@Param("date") LocalDate date);

}
