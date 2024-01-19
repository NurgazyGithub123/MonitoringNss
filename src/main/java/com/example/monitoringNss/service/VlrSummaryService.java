package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import org.springframework.stereotype.Service;

@Service
public interface VlrSummaryService {

    VlrSummary create(CreateVlrSummaryRequest createVlrSummaryRequest);
}
