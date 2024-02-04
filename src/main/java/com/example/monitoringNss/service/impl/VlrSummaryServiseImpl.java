package com.example.monitoringNss.service.impl;


import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.mapper.VlrSummaryMapper;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {

    private final VlrSummaryRepo vlrSummaryRepo;

    public List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest){

        return VlrSummaryMapper.INSTANCE.entityToDtoList(vlrSummaryRepo.saveAll
                        (VlrSummaryMapper.INSTANCE.requestToEntityList(createVlrSummaryRequest)));
    }

}
