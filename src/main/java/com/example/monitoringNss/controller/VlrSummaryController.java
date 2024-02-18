package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.example.monitoringNss.service.VlrSummaryKpiService;
import com.example.monitoringNss.service.VlrSummaryService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
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


    @PostMapping("/saveToVlr")
    public ResponseEntity<?> saveAllToVlr(@RequestBody @Validated List<VlrSummaryRequest> createVlrSummaryRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vlrSummaryService.saveAll(createVlrSummaryRequest));
    }

    @PutMapping("/saveAvgDateToVlrSummaryKpiAll")
    public List<VlrSummaryKpiDto> saveAvgDateToVlrSummaryKpiAll(){
        return vlrSummaryKpiService.avgDayAll();
    }

    @GetMapping("/findAvgDateAll")
    public List<VlrSummaryKpiDto> findAvgDateAll(){
        return vlrSummaryKpiService.findAvgDateAll();
    }

    @PostMapping(value = "/uploadCsvAllDate")
    public ResponseEntity<?> uploadVlrSummaryAllDate() throws IOException, CsvException {
        vlrSummaryService.uploadVlrSummaryAllDate();

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @PostMapping(value = "/uploadCsvYesterday")
    public ResponseEntity<?> uploadVlrSummaryYesterday() throws IOException, CsvException {
        vlrSummaryService.uploadVlrSummaryPeriod();

        return ResponseEntity
                .status(HttpStatus.OK).body("Success");
    }

    @GetMapping("exportCSv")
    public void exportCsv(HttpServletResponse httpServletResponse) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException{
        String fileName = "export_vslSummary.csv";

        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename " + fileName + "");

        StatefulBeanToCsv<VlrSummaryDto> writer = new StatefulBeanToCsvBuilder<VlrSummaryDto>(httpServletResponse.getWriter())
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(vlrSummaryService.findAll());
    }

}
