package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.model.entity.VlrSummaryKpi;
import com.example.monitoringNss.domain.model.dto.request.VlrSummaryRequest;
import com.example.monitoringNss.service.VlrSummaryKpiService;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vlrSummary")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryController {

    @NonNull
    VlrSummaryService vlrSummaryService;
    @NonNull
    VlrSummaryKpiService vlrSummaryKpiService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated VlrSummaryRequest createVlrSummaryRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vlrSummaryService.create(createVlrSummaryRequest));
    }

    @PostMapping("/saveToVlr")
    public ResponseEntity<?> saveAllToVlr(@RequestBody @Validated List<VlrSummaryRequest> createVlrSummaryRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vlrSummaryService.saveAll(createVlrSummaryRequest));
    }

    @PutMapping("/avgDateAll")
    public List<VlrSummaryKpi> avgDateAll(){
        return vlrSummaryKpiService.avgDayAll();
    }

}
