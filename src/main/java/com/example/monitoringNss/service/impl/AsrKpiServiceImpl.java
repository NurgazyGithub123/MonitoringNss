package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.dto.model.AsrKpiDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.entity.AsrKpi;
import com.example.monitoringNss.domain.repository.AsrKpiRepo;
import com.example.monitoringNss.domain.repository.AsrRepo;
import com.example.monitoringNss.service.AsrKpiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrKpiServiceImpl implements AsrKpiService {

    private final AsrRepo asrRepo;
    private final AsrKpiRepo asrKpiRepo;

    @Override
    public List<AsrKpi> asrFindAll() {

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

            asrKpiRepo.save(asr);
            count++;
            if (count < 10){
                savedAsrKpi.add(asr);
            }
        }
        return savedAsrKpi;
    }
}
