package com.example.monitoringNss.controller;


import com.example.monitoringNss.service.KpiService;
import com.example.monitoringNss.service.TestClass;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.opencsv.exceptions.CsvException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kpi")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KpiController {

    @NonNull KpiService kpiService;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadVlrSummaryYesterday() throws IOException, CsvException, SftpException, JSchException {
        kpiService.uploadVlrSummaryPeriod();

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }
}
