package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.dto.dtos.AsrDtoInterface;
import com.example.monitoringNss.domain.model.dto.dtos.AsrKpiDtoInterface;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsrKpiRepo extends JpaRepository<AsrKpi, Long> {

    @Query(value = "select sum(ta.answer_times) as answerTimes, sum(ta.call_attempt_times) as callAttemptTimes, sum(ta.suc_attempt) as sucAttempt , ta.date, ta.object_instance as objectInstance" +
            " from tb_asr ta group by ta.date, ta.object_instance", nativeQuery = true)
    List<AsrDtoInterface> findAllByDay();

    @Query(value = "SELECT kpi.asr, kpi.ner, kpi.date, kpi.object_instance as objectInstance  from tb_asr_kpi as kpi WHERE kpi.date =:date", nativeQuery = true)
    List<AsrKpiDtoInterface> findBiDate(@Param("date") LocalDate date);

    @Query(value = "SELECT kpi.asr, kpi.ner, kpi.date, kpi.object_instance as objectInstance  from tb_asr_kpi as kpi WHERE kpi.object_instance =:objectInstance", nativeQuery = true)
    List<AsrKpiDtoInterface> findAsrKpiByObjectInstance(@Param("objectInstance") String objectInstance);

}
