package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vlrSummary")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryController {

    @NonNull
    VlrSummaryService vlrSummaryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateVlrSummaryRequest createVlrSummaryRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vlrSummaryService.create(createVlrSummaryRequest));

    }


}
