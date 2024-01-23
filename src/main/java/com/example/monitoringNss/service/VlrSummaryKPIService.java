package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlrSummaryKPIService {

    VlrSummaryKPI avgDay(String date);

    List<VlrSummaryDto> avgDayAll();
}
