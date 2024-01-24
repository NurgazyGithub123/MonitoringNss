package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.config.DateFormatToLocal;
import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {

    private final VlrSummaryRepo vlrSummaryRepo;

    @Override
    public VlrSummary create(VlrSummaryRequest request) {

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
        savedVlrSummary.setWeek("1");

        return vlrSummaryRepo.save(savedVlrSummary);
    }



    public List<VlrSummary> saveData(List<VlrSummaryRequest> createVlrSummaryRequest){

        List<VlrSummary> list = new ArrayList<>();

        for (VlrSummaryRequest vlrSummary: createVlrSummaryRequest) {
            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(vlrSummary.getStartTime());
            savedVlrSummary.setMsxName(vlrSummary.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummary.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummary.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummary.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummary.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummary.getTotal());
            savedVlrSummary.setBitel(vlrSummary.getTotal() - vlrSummary.getVlrCamel() - vlrSummary.getVlrRoaming());
            savedVlrSummary.setDate(vlrSummary.getStartTime().toLocalDate());
            savedVlrSummary.setTime(vlrSummary.getStartTime().toLocalTime());
            savedVlrSummary.setYear(String.valueOf(vlrSummary.getStartTime().getYear()));
            savedVlrSummary.setWeek("1");

            vlrSummaryRepo.save(savedVlrSummary);
            list.add(savedVlrSummary);

        }

        return list;

    }

}
