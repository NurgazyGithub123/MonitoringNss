package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.dto.AsrKpiDto;
import com.example.monitoringNss.domain.model.entity.AsrKpi;

import java.util.ArrayList;
import java.util.List;

public class AsrKpiMapper {

    public static final AsrKpiMapper INSTANCE = new AsrKpiMapper();

    public List<AsrKpiDto> toDtoList(List<AsrKpi> asrKpi){

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

    public List<AsrKpi> toEntityList(List<AsrKpiDto> asrKpiDto){

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

    public AsrKpi toEntity(AsrKpiDto asrKpiDto){

            AsrKpi asrKpi = new AsrKpi();
            asrKpi.setId(asrKpiDto.getId());
            asrKpi.setDate(asrKpiDto.getDate());
            asrKpi.setObjectInstance(asrKpiDto.getObjectInstance());
            asrKpi.setSucAttempt(asrKpiDto.getSucAttempt());
            asrKpi.setAsr(asrKpiDto.getAsr());
            asrKpi.setNer(asrKpiDto.getNer());
            asrKpi.setAnswerTimes(asrKpiDto.getAnswerTimes());
            asrKpi.setCallAttemptTimes(asrKpiDto.getCallAttemptTimes());

        return asrKpi;
    }

    public AsrKpiDto toDto(AsrKpi asrKpi){

        return AsrKpiDto
                .builder()
                .id(asrKpi.getId())
                .ner(asrKpi.getNer())
                .date(asrKpi.getDate())
                .asr(asrKpi.getAsr())
                .callAttemptTimes(asrKpi.getCallAttemptTimes())
                .objectInstance(asrKpi.getObjectInstance())
                .sucAttempt(asrKpi.getSucAttempt())
                .answerTimes(asrKpi.getAnswerTimes())
                .build();
    }
}
