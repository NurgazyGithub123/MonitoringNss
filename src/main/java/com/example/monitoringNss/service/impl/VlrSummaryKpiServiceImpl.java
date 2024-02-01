package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import com.example.monitoringNss.domain.repository.VlrSummaryKpiRepo;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryKpiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKpiServiceImpl implements VlrSummaryKpiService {

    private final VlrSummaryKpiRepo vlrSummaryKpiRepo;
    private final VlrSummaryRepo vlrSummaryRepo;

    public VlrSummaryKpi avgDay(String date){

        VlrSummaryKpiDto vlrSummary = vlrSummaryKpiRepo.avgDay(LocalDate.parse(date));
        VlrSummaryKpi vlrSummaryKpi = new VlrSummaryKpi();

        vlrSummaryKpi.setDate(vlrSummary.getDate());
        vlrSummaryKpi.setYear(vlrSummary.getYear());
        vlrSummaryKpi.setMonth(vlrSummary.getMonth());
        vlrSummaryKpi.setMsxName(vlrSummary.getMsxName());
        vlrSummaryKpi.setVlr4g( vlrSummary.getVlr4g());
        vlrSummaryKpi.setPrepaid(vlrSummary.getPrepaid());
        vlrSummaryKpi.setTotal(vlrSummary.getTotal());
        vlrSummaryKpi.setPostpaid(vlrSummary.getPostpaid());
        vlrSummaryKpi.setCamel(vlrSummary.getCamel());
        vlrSummaryKpi.setRoaming(vlrSummary.getRoaming());

        return vlrSummaryKpi;
    }

    @Override
    public List<VlrSummaryKpi> avgDayAll() {

        List<VlrSummaryDto> vlrSummaryList  = vlrSummaryRepo.avgDayAll();
        List<VlrSummaryKpi> savedVlr = new ArrayList<>();

        for (VlrSummaryDto vlrSummary : vlrSummaryList) {

            VlrSummaryKpi vlrSummaryKpi = new VlrSummaryKpi();
            vlrSummaryKpi.setDate(vlrSummary.getDate());
            vlrSummaryKpi.setMonth(String.valueOf(vlrSummary.getDate().getMonth()));
            vlrSummaryKpi.setYear(String.valueOf(vlrSummary.getDate().getYear()));
            vlrSummaryKpi.setVlr4g(vlrSummary.getVlrSGs());
            vlrSummaryKpi.setPrepaid(vlrSummary.getVlrLocal());
            vlrSummaryKpi.setTotal(vlrSummary.getTotal());
            vlrSummaryKpi.setPostpaid(vlrSummary.getBitel());
            vlrSummaryKpi.setCamel(vlrSummary.getVlrCamel());
            vlrSummaryKpi.setRoaming(vlrSummary.getVlrRoaming());
            vlrSummaryKpi.setMsxName("network");

            savedVlr.add( vlrSummaryKpi);
            vlrSummaryKpiRepo.save(vlrSummaryKpi);
        }
        return  savedVlr;
    }
}
