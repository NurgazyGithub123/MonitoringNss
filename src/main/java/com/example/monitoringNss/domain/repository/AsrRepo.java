package com.example.monitoringNss.domain.repository;


import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrRepo extends JpaRepository<Asr, Long> {

    @Query(value = "SELECT start_time as startTime, ne_name as neName, region FROM tb_asr", nativeQuery = true)
    List<AsrDto> getAllByNeNameAndStartTime();

    @Query(value = "SELECT * FROM tb_asr WHERE region =:region", nativeQuery = true)
    List<Asr> getAllbyRegion(@Param("region") String region);
    @Query(value = "SELECT t.id as id, t.start_time as startTime, t.ne_name as neName, t.local_subscribers * 2 as LocalSubscribers, region FROM tb_asr t", nativeQuery = true)
    List<AsrDto> getAllnewKPI();

    @Query(value = "SELECT t.id as id, t.start_time as startTime, t.ne_name as neName, t.local_subscribers as LocalSubscribers, region FROM tb_asr t", nativeQuery = true)
    List<AsrDto> getAllnewKPI2();

}
