package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.example.monitoringNss.domain.model.dto.AsrKpiDto;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
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
    public List<AsrKpi> asrSaveAlltoAsrKPI() {

        List<AsrDto> asrFindAllDay = asrKpiRepo.findAllByDay();
        List<AsrKpi> savedAsrKpi = new ArrayList<>();

        int count = 0;

        for(AsrDto asrKpi : asrFindAllDay){
            AsrKpi asr = new AsrKpi();
            asr.setObjectInstance(asrKpi.getObjectInstance());
            asr.setDate(asrKpi.getDate());
            asr.setSucAttempt(asrKpi.getSucAttempt());
            asr.setAsr(asrKpi.getCallAttemptTimes() > 0 ? (double)asrKpi.getAnswerTimes()
                    / asrKpi.getCallAttemptTimes()*100 : asrKpi.getCallAttemptTimes());
            asr.setNer(asrKpi.getCallAttemptTimes() > 0 ? asrKpi.getSucAttempt()
                    / asrKpi.getCallAttemptTimes()*100 : asrKpi.getCallAttemptTimes());

            savedAsrKpi.add(asr);
        }
        return asrKpiRepo.saveAll(savedAsrKpi);
    }

    @Override
    public List<AsrKpiDto> asrFindByDate(String date) {
        List<AsrKpiDto> asrKpiDto = asrKpiRepo.findBiDate(LocalDate.parse(date));
        System.out.println(asrKpiDto);

        return asrKpiDto;
    }

    @Override
    public AsrKpi asrFindByID(Long id) {
        return asrKpiRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asr with id = " + id + "not found"));

    }

    @Override
    public List<AsrKpiDto> asrFindByObjectInstance(String objectInstance) {
        return asrKpiRepo.findAsrKpiByObjectInstance(objectInstance);
    }
}
