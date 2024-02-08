package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface VlrSummaryService {

    List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest);

    void uploadVlrSummary() throws IOException, CsvException;

    List<VlrSummary> findAll();
}
