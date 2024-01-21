package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import org.springframework.stereotype.Service;

@Service
public interface VlrSummaryKPIService {

    VlrSummaryKPI avgDay(String date);
}
