package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.config.DateFormatToLocal;
import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;

import java.util.ArrayList;
import java.util.List;

public class VlrSummaryMapper {

    public static final VlrSummaryMapper INSTANCE = new VlrSummaryMapper();

    public List<VlrSummary> requestToEntityList(List<VlrSummaryRequest> vlrSummaryRequests) {

        List<VlrSummary> list = new ArrayList<>();

        for (VlrSummaryRequest vlrSummary : vlrSummaryRequests) {
            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(DateFormatToLocal.dateFormatУMD(vlrSummary.getStartTime()));
            savedVlrSummary.setMsxName(vlrSummary.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummary.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummary.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummary.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummary.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummary.getTotal());
            savedVlrSummary.setBitel(vlrSummary.getTotal() - vlrSummary.getVlrCamel() - vlrSummary.getVlrRoaming());
            savedVlrSummary.setDate(DateFormatToLocal.dateFormatУMD(vlrSummary.getStartTime()).toLocalDate());
            savedVlrSummary.setTime(DateFormatToLocal.dateFormatУMD(vlrSummary.getStartTime()).toLocalTime());
            savedVlrSummary.setYear(DateFormatToLocal.formatToYearStr(vlrSummary.getStartTime()));
            savedVlrSummary.setWeek(DateFormatToLocal.formatToWeek(vlrSummary.getStartTime()));

            list.add(savedVlrSummary);
        }
        return list;
    }

    public List<VlrSummary> dtoToEntityList(List<VlrSummaryDto> summaryDtos) {

        List<VlrSummary> list = new ArrayList<>();

        for (VlrSummaryDto vlrSummary : summaryDtos) {
            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(vlrSummary.getStartTime());
            savedVlrSummary.setMsxName(vlrSummary.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummary.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummary.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummary.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummary.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummary.getTotal());
            savedVlrSummary.setBitel(vlrSummary.getBitel());
            savedVlrSummary.setDate(vlrSummary.getDate());
            savedVlrSummary.setTime(vlrSummary.getTime());
            savedVlrSummary.setYear(vlrSummary.getYear());
            savedVlrSummary.setWeek(vlrSummary.getWeek());

            list.add(savedVlrSummary);
        }
        return list;
    }

    public List<VlrSummaryDto> entityToDtoList(List<VlrSummary> summary) {

        List<VlrSummaryDto> list = new ArrayList<>();

        for (VlrSummary vlrSummary : summary) {
            VlrSummaryDto vlrSummaryDto = VlrSummaryDto
                    .builder()
                    .id(vlrSummary.getId())
                    .startTime(vlrSummary.getStartTime())
                    .vlrCamel(vlrSummary.getVlrCamel())
                    .vlrSGs(vlrSummary.getVlrSGs())
                    .vlrLocal(vlrSummary.getVlrLocal())
                    .vlrRoaming(vlrSummary.getVlrRoaming())
                    .msxName(vlrSummary.getMsxName())
                    .bitel(vlrSummary.getBitel())
                    .total(vlrSummary.getTotal())
                    .week(vlrSummary.getWeek())
                    .year(vlrSummary.getYear())
                    .time(vlrSummary.getTime())
                    .date(vlrSummary.getDate())
                    .build();

            list.add(vlrSummaryDto);
        }
        return list;
    }

    public VlrSummary requestToEntity(VlrSummaryRequest vlrSummaryRequests) {

            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(DateFormatToLocal.dateFormatУMD(vlrSummaryRequests.getStartTime()));
            savedVlrSummary.setMsxName(vlrSummaryRequests.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummaryRequests.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummaryRequests.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummaryRequests.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummaryRequests.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummaryRequests.getTotal());
            savedVlrSummary.setBitel(vlrSummaryRequests.getTotal() - vlrSummaryRequests.getVlrCamel() - vlrSummaryRequests.getVlrRoaming());
            savedVlrSummary.setDate(DateFormatToLocal.dateFormatУMD(vlrSummaryRequests.getStartTime()).toLocalDate());
            savedVlrSummary.setTime(DateFormatToLocal.dateFormatУMD(vlrSummaryRequests.getStartTime()).toLocalTime());
            savedVlrSummary.setYear(DateFormatToLocal.formatToYearStr(vlrSummaryRequests.getStartTime()));
            savedVlrSummary.setWeek(DateFormatToLocal.formatToWeek(vlrSummaryRequests.getStartTime()));

            return savedVlrSummary;

    }

    public VlrSummary dtoToEntity(VlrSummaryDto vlrSummary) {

            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(vlrSummary.getStartTime());
            savedVlrSummary.setMsxName(vlrSummary.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummary.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummary.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummary.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummary.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummary.getTotal());
            savedVlrSummary.setBitel(vlrSummary.getBitel());
            savedVlrSummary.setDate(vlrSummary.getDate());
            savedVlrSummary.setTime(vlrSummary.getTime());
            savedVlrSummary.setYear(vlrSummary.getYear());
            savedVlrSummary.setWeek(vlrSummary.getWeek());

          return savedVlrSummary;
    }

    public VlrSummaryDto entityToDto(VlrSummary vlrSummary) {

            VlrSummaryDto vlrSummaryDto = VlrSummaryDto
                    .builder()
                    .id(vlrSummary.getId())
                    .startTime(vlrSummary.getStartTime())
                    .vlrCamel(vlrSummary.getVlrCamel())
                    .vlrSGs(vlrSummary.getVlrSGs())
                    .vlrLocal(vlrSummary.getVlrLocal())
                    .vlrRoaming(vlrSummary.getVlrRoaming())
                    .msxName(vlrSummary.getMsxName())
                    .bitel(vlrSummary.getBitel())
                    .total(vlrSummary.getTotal())
                    .week(vlrSummary.getWeek())
                    .year(vlrSummary.getYear())
                    .time(vlrSummary.getTime())
                    .date(vlrSummary.getDate())
                    .build();

            return vlrSummaryDto;
    }
}
