package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlrSummaryService {

    VlrSummary create(VlrSummaryRequest createVlrSummaryRequest);

    List<VlrSummary> saveData(List<VlrSummaryRequest> createVlrSummaryRequest);

}
