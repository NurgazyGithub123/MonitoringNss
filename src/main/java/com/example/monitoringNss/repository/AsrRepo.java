package com.example.monitoringNss.repository;

import com.example.monitoringNss.model.dto.AsrDto;
import com.example.monitoringNss.model.entity.Asr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrRepo extends JpaRepository<Asr, Long> {

    @Query(value = "SELECT start_time as startTime, ne_name as neName, region FROM tb_asr", nativeQuery = true)
    List<AsrDto> getAllByNeNameAndStartTime();
}
