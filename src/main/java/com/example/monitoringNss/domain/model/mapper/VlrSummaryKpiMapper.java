package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;

import java.util.ArrayList;
import java.util.List;

public class VlrSummaryKpiMapper {

    public static final VlrSummaryKpiMapper INSTANCE = new VlrSummaryKpiMapper();

    public VlrSummaryKpi dtoToEntity(VlrSummaryKpiDto vlrSummaryKpiDto){

        VlrSummaryKpi vlrSummaryKpi = new VlrSummaryKpi();
        vlrSummaryKpi.setId(vlrSummaryKpiDto.getId());
        vlrSummaryKpi.setVlr4g(vlrSummaryKpiDto.getVlr4g());
        vlrSummaryKpi.setRoaming(vlrSummaryKpiDto.getRoaming());
        vlrSummaryKpi.setMonth(vlrSummaryKpiDto.getMonth());
        vlrSummaryKpi.setMsxName(vlrSummaryKpiDto.getMsxName());
        vlrSummaryKpi.setDate(vlrSummaryKpiDto.getDate());
        vlrSummaryKpi.setCamel(vlrSummaryKpiDto.getCamel());
        vlrSummaryKpi.setTotal(vlrSummaryKpiDto.getTotal());
        vlrSummaryKpi.setPostpaid(vlrSummaryKpiDto.getPostpaid());
        vlrSummaryKpi.setPrepaid(vlrSummaryKpiDto.getPrepaid());
        vlrSummaryKpi.setYear(vlrSummaryKpiDto.getYear());

        return vlrSummaryKpi;
    }

    public VlrSummaryKpiDto entityToDto(VlrSummaryKpi vlrSummaryKpi){

       return VlrSummaryKpiDto.builder()
               .id(vlrSummaryKpi.getId())
               .vlr4g(vlrSummaryKpi.getVlr4g())
               .roaming(vlrSummaryKpi.getRoaming())
               .camel(vlrSummaryKpi.getCamel())
               .month(vlrSummaryKpi.getMonth())
               .prepaid(vlrSummaryKpi.getPrepaid())
               .total(vlrSummaryKpi.getTotal())
               .year(vlrSummaryKpi.getYear())
               .msxName(vlrSummaryKpi.getMsxName())
               .postpaid(vlrSummaryKpi.getPostpaid())
               .date(vlrSummaryKpi.getDate())
               .build();
    }

    public List<VlrSummaryKpi> dtoToEntityList(List<VlrSummaryKpiDto> vlrSummaryKpiDtos){

        List<VlrSummaryKpi> vlrSummaryKpiList = new ArrayList<>();

        for (VlrSummaryKpiDto vlrSummaryKpiDto : vlrSummaryKpiDtos){
            VlrSummaryKpi vlrSummaryKpi = new VlrSummaryKpi();
            vlrSummaryKpi.setId(vlrSummaryKpiDto.getId());
            vlrSummaryKpi.setVlr4g(vlrSummaryKpiDto.getVlr4g());
            vlrSummaryKpi.setRoaming(vlrSummaryKpiDto.getRoaming());
            vlrSummaryKpi.setMonth(vlrSummaryKpiDto.getMonth());
            vlrSummaryKpi.setMsxName(vlrSummaryKpiDto.getMsxName());
            vlrSummaryKpi.setDate(vlrSummaryKpiDto.getDate());
            vlrSummaryKpi.setCamel(vlrSummaryKpiDto.getCamel());
            vlrSummaryKpi.setTotal(vlrSummaryKpiDto.getTotal());
            vlrSummaryKpi.setPostpaid(vlrSummaryKpiDto.getPostpaid());
            vlrSummaryKpi.setPrepaid(vlrSummaryKpiDto.getPrepaid());
            vlrSummaryKpi.setYear(vlrSummaryKpiDto.getYear());

            vlrSummaryKpiList.add(vlrSummaryKpi);
        }

        return vlrSummaryKpiList;
    }

    public List<VlrSummaryKpiDto> entityToDtoList(List<VlrSummaryKpi> vlrSummaryKpis){

        List<VlrSummaryKpiDto> vlrSummaryKpiDtoList = new ArrayList<>();

        for (VlrSummaryKpi vlrSummaryKpi : vlrSummaryKpis){
            VlrSummaryKpiDto vlrSummaryKpiDto = VlrSummaryKpiDto.builder()
                    .id(vlrSummaryKpi.getId())
                    .vlr4g(vlrSummaryKpi.getVlr4g())
                    .roaming(vlrSummaryKpi.getRoaming())
                    .camel(vlrSummaryKpi.getCamel())
                    .month(vlrSummaryKpi.getMonth())
                    .prepaid(vlrSummaryKpi.getPrepaid())
                    .total(vlrSummaryKpi.getTotal())
                    .year(vlrSummaryKpi.getYear())
                    .msxName(vlrSummaryKpi.getMsxName())
                    .postpaid(vlrSummaryKpi.getPostpaid())
                    .date(vlrSummaryKpi.getDate())
                    .build();

            vlrSummaryKpiDtoList.add(vlrSummaryKpiDto);
        }
        return vlrSummaryKpiDtoList;
    }
}
