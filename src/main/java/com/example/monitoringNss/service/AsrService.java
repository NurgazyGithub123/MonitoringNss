package com.example.monitoringNss.service;

import com.example.monitoringNss.model.dto.AsrDto;
import com.example.monitoringNss.model.dto.AsrRegion;
import com.example.monitoringNss.model.entity.Asr;
import com.example.monitoringNss.model.request.CreateAsrRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsrService {
        Asr create(CreateAsrRequest request);

        Asr getById(Long id);

        List<Asr> getAll();


        List<AsrDto> getAllByNeNameAndStartTime();

        List<Asr> getAllbyRegion(String region);

}
