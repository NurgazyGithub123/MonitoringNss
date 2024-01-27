package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrKpiRepo extends JpaRepository<AsrKpi, Long> {

    @Query(value = "select sum(ta.answer_times) as answerTimes, sum(ta.call_attempt_times) as callAttemptTimes, sum(ta.suc_attempt) as sucAttempt , ta.date, object_instance as objectInstance" +
            " from tb_asr ta group by ta.date, ta.object_instance", nativeQuery = true)
    List<AsrDto> findAllByDay();
}
