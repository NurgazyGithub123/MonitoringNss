package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.dto.AsrKpiDto;
import com.example.monitoringNss.domain.model.entity.AsrKpi;

import java.util.ArrayList;
import java.util.List;

public class AsrKpiMapper {

    public static final AsrKpiMapper INSTANCE = new AsrKpiMapper();

    public List<AsrKpiDto> toDto(List<AsrKpi> asrKpi){

        List<AsrKpiDto> asrKpiDtos = new ArrayList<>();
        for (AsrKpi asrlist : asrKpi){

            AsrKpiDto asrKpiDto = AsrKpiDto.builder()
                    .callAttemptTimes(asrlist.getCallAttemptTimes())
                    .objectInstance(asrlist.getObjectInstance())
                    .sucAttempt(asrlist.getSucAttempt())
                    .answerTimes(asrlist.getAnswerTimes())
                    .date(asrlist.getDate())
                    .asr(asrlist.getAsr())
                    .ner(asrlist.getNer())
                    .build();

            asrKpiDtos.add(asrKpiDto);
        }
        return asrKpiDtos;
    }

    public List<AsrKpi> toEntity(List<AsrKpiDto> asrKpiDto){

        List<AsrKpi> asrKpis = new ArrayList<>();
        for (AsrKpiDto asrDtolist : asrKpiDto){

            AsrKpi asrKpi = AsrKpi.builder()
                    .callAttemptTimes(asrDtolist.getCallAttemptTimes())
                    .objectInstance(asrDtolist.getObjectInstance())
                    .sucAttempt(asrDtolist.getSucAttempt())
                    .answerTimes(asrDtolist.getAnswerTimes())
                    .date(asrDtolist.getDate())
                    .asr(asrDtolist.getAsr())
                    .ner(asrDtolist.getNer())
                    .build();

            asrKpis.add(asrKpi);
        }
        return asrKpis;
    }
}
