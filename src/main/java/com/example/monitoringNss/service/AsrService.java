package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.AsrRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsrService {

        Asr create(AsrRequest asrRequest);

        Asr getById(Long id);

        List<Asr> getAll();


        List<AsrDto> getAllByNeNameAndStartTime();

        List<Asr> getAllbyRegion(String region);

        List<Asr> getAllisEmpty(String region);

        Asr updateByID(Long id, Asr asr);

        List<AsrDto> getAllnewKPI();

        List<AsrDto> getAllnewKPI2();
}
