package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.entity.AsrKpi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsrKpiService{

    List<AsrKpi> asrFindAll();
}
