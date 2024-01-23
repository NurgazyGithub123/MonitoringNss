package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlrSummaryKpiService {

    VlrSummaryKpi avgDay(String date);

    List<VlrSummaryKpi> avgDayAll();
}
