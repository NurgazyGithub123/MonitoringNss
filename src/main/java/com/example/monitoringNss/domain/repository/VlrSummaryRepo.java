package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VlrSummaryRepo extends JpaRepository<VlrSummary, Long> {

    @Query(value = "select avg(tv.total) as total, avg(tv.vlr_camel) as vlrCamel, avg(tv.bitel) as bitel, " +
            "avg(tv.vlr_local) as vlrLocal, avg(tv.vlr_roaming) as vlrRoaming, avg(tv.vlrsgs) as vlrSGs " +
            "from tb_vlrsummary as tv where DATE (tv.date) =:date", nativeQuery = true)
    VlrSummaryDto avgDay (@Param("date") LocalDate date);

    @Query(value = "select avg(tv.total) as total, avg(tv.vlr_camel) as vlrCamel, avg(tv.bitel) as bitel, " +
            "avg(tv.vlr_local) as vlrLocal, avg(tv.vlr_roaming) as vlrRoaming, avg(tv.vlrsgs) as vlrSGs " +
            "from tb_vlrsummary as tv GROUP BY date", nativeQuery = true)
    List<VlrSummaryDto> avgDayAll ();
}
