package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.dto.model.AsrDto2;
import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import com.example.monitoringNss.service.VlrSummaryKPIService;
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
    VlrSummaryKPIService vlrSummaryKPIService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateVlrSummaryRequest createVlrSummaryRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vlrSummaryService.create(createVlrSummaryRequest));
    }

    @PostMapping("/saveToVlr")
    public ResponseEntity<?> saveToVlr(@RequestBody @Validated List<VlrSummary> createVlrSummaryRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vlrSummaryService.saveData(createVlrSummaryRequest));
    }

    @PutMapping("/avgDate/{date}")
    public ResponseEntity<?> avgDate(@PathVariable String date){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vlrSummaryKPIService.avgDay(date));
    }

}
