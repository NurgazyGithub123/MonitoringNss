package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import com.example.monitoringNss.domain.repository.VlrSummaryKpiRepo;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryKPIService;
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
public class VlrSummaryKPIServiceImpl implements VlrSummaryKPIService {

    private final VlrSummaryKpiRepo vlrSummaryKpiRepo;
    private final VlrSummaryRepo vlrSummaryRepo;

    public VlrSummaryKPI avgDay(String date){

        VlrSummaryDto vlrSummary = vlrSummaryRepo.avgDay(LocalDate.parse(date));
        VlrSummaryKPI vlrSummaryKPI = new VlrSummaryKPI();


        vlrSummaryKPI.setDate(LocalDate.parse(date));
        vlrSummaryKPI.setYear(String.valueOf(LocalDate.parse(date).getYear()));
        vlrSummaryKPI.setMonth(String.valueOf(LocalDate.parse(date).getMonth()));
        vlrSummaryKPI.setVlr4g(vlrSummary.getVlrSGs());
        vlrSummaryKPI.setPrepaid(vlrSummary.getvlrLocal());
        vlrSummaryKPI.setTotal(vlrSummary.getTotal());
        vlrSummaryKPI.setPostpaid(vlrSummary.getBitel());
        vlrSummaryKPI.setCamel(vlrSummary.getVlrCamel());
        vlrSummaryKPI.setRoaming(vlrSummary.getvlrRoaming());


        System.out.println(vlrSummaryKPI.getVlr4g());
        System.out.println(vlrSummaryKPI.getPrepaid());
        System.out.println(vlrSummaryKPI.getPostpaid());

        return vlrSummaryKpiRepo.save(vlrSummaryKPI);
    }

    @Override
    public List<VlrSummaryDto> avgDayAll() {

        List<VlrSummaryDto> vlrSummaryDtoList  = vlrSummaryRepo.avgDayAll();
        List<VlrSummaryDto> savedVlr = new ArrayList<>();

        for (VlrSummaryDto vlrSummary : vlrSummaryDtoList) {

//            VlrSummaryKPI vlrSummaryKPI = new VlrSummaryKPI();
//            vlrSummaryKPI.setDate(vlrSummary.getDate());
//            vlrSummaryKPI.setVlr4g();
//            vlrSummaryKPI.setPrepaid();
//            vlrSummaryKPI.setTotal();
//            vlrSummaryKPI.setPostpaid();
//            vlrSummaryKPI.setCamel();
//            vlrSummaryKPI.setRoaming();
        }

        return null;
    }
}
