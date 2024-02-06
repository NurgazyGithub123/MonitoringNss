package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.dto.dtos.VlrSummaryDtoInterface;
import com.example.monitoringNss.domain.model.dto.dtos.VlrSummaryKpiDtoInterface;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import com.example.monitoringNss.domain.model.mapper.VlrSummaryKpiMapper;
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

    public VlrSummaryKpiDto avgDay(String date){

        VlrSummaryKpiDtoInterface vlrSummary = vlrSummaryKpiRepo.avgDay(LocalDate.parse(date));
        VlrSummaryKpiDto vlrSummaryKpi = VlrSummaryKpiDto
                .builder()
                .id(vlrSummary.getId())
                .vlr4g(vlrSummary.getVlr4g())
                .total(vlrSummary.getTotal())
                .year(vlrSummary.getYear())
                .month(vlrSummary.getMonth())
                .roaming(vlrSummary.getRoaming())
                .camel(vlrSummary.getCamel())
                .msxName(vlrSummary.getMsxName())
                .prepaid(vlrSummary.getPrepaid())
                .postpaid(vlrSummary.getPostpaid())
                .date(vlrSummary.getDate())
                .week(vlrSummary.getWeek())
                .build();

        return vlrSummaryKpi;
    }

    @Override
    public List<VlrSummaryKpiDto> avgDayAll() {

        List<VlrSummaryDtoInterface> vlrSummaryList  = vlrSummaryRepo.avgDayAll();
        List<VlrSummaryKpiDto> savedVlr = new ArrayList<>();

        for (VlrSummaryDtoInterface vlrSummary : vlrSummaryList) {

            VlrSummaryKpiDto vlrSummaryKpi = VlrSummaryKpiDto
                    .builder()
                    .id(vlrSummary.getId())
                    .vlr4g(vlrSummary.getVlrSGs())
                    .total(vlrSummary.getTotal())
                    .year(String.valueOf(vlrSummary.getDate().getYear()))
                    .month(String.valueOf(vlrSummary.getDate().getMonth()))
                    .roaming(vlrSummary.getVlrRoaming())
                    .camel(vlrSummary.getVlrCamel())
                    .msxName(vlrSummary.getMsxName())
                    .prepaid(vlrSummary.getVlrLocal())
                    .postpaid(vlrSummary.getBitel())
                    .date(vlrSummary.getDate())
                    .week(vlrSummary.getWeek())
                    .build();

            savedVlr.add( vlrSummaryKpi);

        }
        List<VlrSummaryKpi> list = VlrSummaryKpiMapper.INSTANCE.dtoToEntityList(savedVlr);

        vlrSummaryKpiRepo.saveAll(list);
        return  savedVlr;
    }

    @Override
    public List<VlrSummaryKpiDto> findAvgDateAll() {

        List<VlrSummaryDtoInterface> vlrSummaryList  = vlrSummaryRepo.avgDayAll();
        List<VlrSummaryKpiDto> savedVlr = new ArrayList<>();

        for (VlrSummaryDtoInterface vlrSummary : vlrSummaryList) {

            VlrSummaryKpiDto vlrSummaryKpi = VlrSummaryKpiDto
                    .builder()
                    .id(vlrSummary.getId())
                    .vlr4g(vlrSummary.getVlrSGs())
                    .total(vlrSummary.getTotal())
                    .year(String.valueOf(vlrSummary.getDate().getYear()))
                    .month(String.valueOf(vlrSummary.getDate().getMonth()))
                    .roaming(vlrSummary.getVlrRoaming())
                    .camel(vlrSummary.getVlrCamel())
                    .msxName(vlrSummary.getMsxName())
                    .prepaid(vlrSummary.getVlrLocal())
                    .postpaid(vlrSummary.getBitel())
                    .week(vlrSummary.getWeek())
                    .date(vlrSummary.getDate())

                    .build();
            savedVlr.add( vlrSummaryKpi);
        }
        return savedVlr;
    }
}
