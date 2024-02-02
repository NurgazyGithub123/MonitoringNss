package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.CreateAsrRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsrService {


    List<AsrDto> create(List<CreateAsrRequest> createAsrRequest);

    List<Asr> updateAll();

}
