package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.dto.dtos.VlrSummaryDtoInterface;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VlrSummaryRepo extends JpaRepository<VlrSummary, Long> {

    @Query(value = "select tv.date as date ,avg(tv.total) as total, avg(tv.vlr_camel) as vlrCamel, avg(tv.bitel) as bitel, " +
            "avg(tv.vlr_local) as vlrLocal, avg(tv.vlr_roaming) as vlrRoaming, avg(tv.vlrsgs) as vlrSGs " +
            "from tb_vlrsummary as tv GROUP BY tv.date Order by tv.date", nativeQuery = true)
    List<VlrSummaryDtoInterface> avgDayAll ();
}
