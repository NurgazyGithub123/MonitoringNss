package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.dto.dtos.AsrDtoInterface;
import com.example.monitoringNss.domain.model.dto.AsrKpiDto;
import com.example.monitoringNss.domain.model.dto.dtos.AsrKpiDtoInterface;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
import com.example.monitoringNss.domain.model.mapper.AsrKpiMapper;
import com.example.monitoringNss.domain.repository.AsrKpiRepo;
import com.example.monitoringNss.exception.EntityNotFoundException;
import com.example.monitoringNss.service.AsrKpiService;
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
public class AsrKpiServiceImpl implements AsrKpiService {

    private final AsrKpiRepo asrKpiRepo;

    @Override
    public List<AsrKpiDto> asrSaveAlltoAsrKPI() {

        List<AsrDtoInterface> asrFindAllDay = asrKpiRepo.findAllByDay();
        List<AsrKpi> savedAsrKpi = new ArrayList<>();

        for(AsrDtoInterface asrDto : asrFindAllDay){
            AsrKpi asrKpi = new AsrKpi();
            asrKpi.setObjectInstance(asrDto.getObjectInstance());
            asrKpi.setDate(asrDto.getDate());
            asrKpi.setSucAttempt(asrDto.getSucAttempt());
            asrKpi.setAsr(asrDto.getCallAttemptTimes() > 0 ? (double)asrDto.getAnswerTimes()
                    / asrDto.getCallAttemptTimes()*100 : asrDto.getCallAttemptTimes());
            asrKpi.setNer(asrDto.getCallAttemptTimes() > 0 ? (double)asrDto.getSucAttempt()
                    / asrDto.getCallAttemptTimes()*100 : asrDto.getCallAttemptTimes());

            savedAsrKpi.add(asrKpi);
        }
        return AsrKpiMapper.INSTANCE.toDto(asrKpiRepo.saveAll(savedAsrKpi));
    }

    @Override
    public List<AsrKpiDto> asrFindByDate(LocalDate date) {
        List<AsrKpiDtoInterface> asrFindList = asrKpiRepo.findBiDate(date);
        List<AsrKpiDto> asrKpiDtos = new ArrayList<>();

        for (AsrKpiDtoInterface asrKpiDto : asrFindList){
            AsrKpiDto asrKpiDto1 = AsrKpiDto.builder()
                    .asr(asrKpiDto.getAsr())
                    .build();
            asrKpiDtos.add(asrKpiDto1);
        }

        return asrKpiDtos;
    }

    @Override
    public AsrKpi asrFindByID(Long id) {
        return asrKpiRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asr with id = " + id + "not found"));

    }

    @Override
    public List<AsrKpiDto> asrFindByObjectInstance(String objectInstance) {
        List<AsrKpiDtoInterface> asrKpiDto  = asrKpiRepo.findAsrKpiByObjectInstance(objectInstance);
        List<AsrKpiDto> asrKpis = new ArrayList<>();

        for (AsrKpiDtoInterface asrKpi : asrKpiDto){
            AsrKpiDto asrKpiDto1 = AsrKpiDto.builder()
                    .asr(asrKpi.getAsr())
                    .objectInstance(asrKpi.getObjectInstance())
                    .ner(asrKpi.getNer())
                    .date(asrKpi.getDate())
                    .build();
            asrKpis.add(asrKpiDto1);
        }

        return asrKpis;
    }
}
