package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.dto.dtos.VlrSummaryDtoInterface;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VlrSummaryRepo extends JpaRepository<VlrSummary, Long> {

    @Query(value = "select tv.date as date ,avg(tv.total) as total, avg(tv.vlr_camel) as vlrCamel, avg(tv.bitel) as bitel, \n" +
            "avg(tv.vlr_local) as vlrLocal, avg(tv.vlr_roaming) as vlrRoaming, avg(tv.vlrsgs) as vlrSGs, tv.week as week, tv.msx_name as msxName\n" +
            "from tb_vlrsummary as tv GROUP BY tv.date, tv.week, tv.msx_name\n" +
            "union all \n" +
            "select res.date as date ,sum(res.total) as total, sum(res.vlrCamel) as vlrCamel, sum(res.bitel) as bitel, \n" +
            "sum(res.vlrLocal) as vlrLocal, sum(res.vlrRoaming) as vlrRoaming, sum(res.vlrSGs) as vlrSGs, res.week as week, res.msxName as msxName \n" +
            "from \n" +
            "(select tv.date as date ,avg(tv.total) as total, avg(tv.vlr_camel) as vlrCamel, avg(tv.bitel) as bitel, \n" +
            "avg(tv.vlr_local) as vlrLocal, avg(tv.vlr_roaming) as vlrRoaming, avg(tv.vlrsgs) as vlrSGs, tv.week as week, \n" +
            "case tv.msx_name\n" +
            "when 'MSX-Bishkek' then 'Network' \n" +
            "when 'MSOFTX3000-OSH' then 'Network' end as msxName\n" +
            "from tb_vlrsummary as tv GROUP BY tv.date, tv.week, tv.msx_name Order by tv.date) as res GROUP BY date, week, res.msxName Order by date", nativeQuery = true)
    List<VlrSummaryDtoInterface> avgDayAll ();


}
