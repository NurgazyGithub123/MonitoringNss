package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VlrSummaryService {

    VlrSummary create(CreateVlrSummaryRequest createVlrSummaryRequest);

    List<VlrSummary> saveData(List<VlrSummary> createVlrSummaryRequest);

    //VlrSummary avgDay(String date);


}
