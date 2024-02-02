package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.AsrKpiDto;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AsrKpiService{

    List<AsrKpiDto> asrSaveAlltoAsrKPI();

    List<AsrKpiDto> asrFindByDate(LocalDate date);

    AsrKpi asrFindByID(Long id);

    List<AsrKpiDto> asrFindByObjectInstance(String objectInstance);
}
