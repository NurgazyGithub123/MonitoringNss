package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.AsrRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsrService {


    List<Asr> create(List<AsrRequest> asrRequest);

    List<Asr> updateAll();
}
