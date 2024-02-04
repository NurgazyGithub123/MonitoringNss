package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VlrSummaryService {

    List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest);

}
