package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import com.example.monitoringNss.domain.repository.VlrSummaryKpiRepo;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryKPIService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKPIServiceImpl implements VlrSummaryKPIService {

    private final VlrSummaryKpiRepo vlrSummaryKpiRepo;
    private final VlrSummaryRepo vlrSummaryRepo;

    public VlrSummaryKPI avgDay(String date){

        VlrSummaryDto vlrSummary = (VlrSummaryDto) vlrSummaryRepo.avgDay(LocalDate.parse(date));
        VlrSummaryKPI vlrSummaryKPI = new VlrSummaryKPI();
        vlrSummaryKPI.setDate(LocalDate.parse(date));
        vlrSummaryKPI.setYear(String.valueOf(LocalDate.parse(date).getYear()));
        vlrSummaryKPI.setMonth(String.valueOf(LocalDate.parse(date).getMonth()));
        vlrSummaryKPI.setVlr4g(vlrSummary.getVlrSGs());
        vlrSummaryKPI.setPrepaid(vlrSummary.getVlrCamel());
        vlrSummaryKPI.setTotal(vlrSummary.getTotal());
        vlrSummaryKPI.setPostpaid(vlrSummary.getBitel());
        vlrSummaryKPI.setCamel(vlrSummaryKPI.getCamel());
         System.out.println(vlrSummary);
        return vlrSummaryKpiRepo.save(vlrSummaryKPI);
    }
}
