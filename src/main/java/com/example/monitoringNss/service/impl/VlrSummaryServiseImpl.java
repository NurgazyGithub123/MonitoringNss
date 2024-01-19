package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {

    private final VlrSummaryRepo vlrSummaryRepo;
    @Override
    public VlrSummary create(CreateVlrSummaryRequest request) {

        VlrSummary savedVlrSummary = new VlrSummary();
        savedVlrSummary.setStartTime(request.getStartTime());
        savedVlrSummary.setMsxName(request.getMsxName());
        savedVlrSummary.setVlrCamel(request.getVlrCamel());
        savedVlrSummary.setVlrLocal(request.getVlrLocal());
        savedVlrSummary.setVlrRoaming(request.getVlrRoaming());
        savedVlrSummary.setVlrSGs(request.getVlrSGs());
        savedVlrSummary.setTotal(request.getTotal());
        savedVlrSummary.setBitel(request.getTotal() - request.getVlrCamel() - request.getVlrRoaming());
        savedVlrSummary.setDate(request.getStartTime().toLocalDate());
        savedVlrSummary.setTime(request.getStartTime().toLocalTime());
        savedVlrSummary.setYear(String.valueOf(request.getStartTime().getYear()));

        return savedVlrSummary;
    }

    

}
