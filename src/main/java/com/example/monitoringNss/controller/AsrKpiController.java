package com.example.monitoringNss.controller;


import com.example.monitoringNss.service.AsrKpiService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/asrKpi")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrKpiController {

    @NonNull
    AsrKpiService asrKpiService;

    @GetMapping("/asrFindAll")
    public ResponseEntity<?> asrFindAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrKpiService.asrFindAll());

    }
}
