package com.example.monitoringNss.controller;

import com.example.monitoringNss.service.VlrSummaryKpiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vlrSummaryKpi")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryKpiController {

    @NonNull
    VlrSummaryKpiService vlrSummaryKpiService;

    @GetMapping("/avgDate/{date}")
    public ResponseEntity<?> avgDate(@PathVariable String date){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vlrSummaryKpiService.avgDay(date));
    }
}
