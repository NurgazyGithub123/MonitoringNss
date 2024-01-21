package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VlrSummaryRepo extends JpaRepository<VlrSummary, Long> {

    @Query(value = "select avg(tv.total) as avg_total, avg(tv.vlr_camel) as avg_camel, avg(tv.bitel) as avg_bitel, " +
            "avg(tv.vlr_local) as avg_local, avg(tv.vlr_roaming) as avg_ruaming, avg(tv.vlrsgs) as avg_Sgs " +
            "from tb_vlrsummary as tv where DATE (tv.date) =:date", nativeQuery = true)
    VlrSummary avgDay (@Param("date") LocalDate date);
}