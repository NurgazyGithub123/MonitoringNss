package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface VlrSummaryService {

    List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest);

    void uploadVlrSummaryPeriod() throws IOException, CsvException;
    void uploadVlrSummaryAllDate() throws IOException, CsvException;


    List<VlrSummaryDto> findAll();

}
