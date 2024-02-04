package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlrSummaryKpiService {

    VlrSummaryKpiDto avgDay(String date);

    List<VlrSummaryKpiDto> avgDayAll();

    List<VlrSummaryKpiDto> findAvgDateAll();
}
