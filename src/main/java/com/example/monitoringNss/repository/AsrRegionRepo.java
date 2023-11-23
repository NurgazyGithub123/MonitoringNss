package com.example.monitoringNss.repository;

import com.example.monitoringNss.model.dto.AsrRegion;
import com.example.monitoringNss.model.entity.Asr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrRegionRepo extends JpaRepository<Asr, String> {

    @Query(value = "SELECT * FROM tb_asr WHERE region = ?", nativeQuery = true)
    List<Asr> getAllbyRegion(String region);

}
