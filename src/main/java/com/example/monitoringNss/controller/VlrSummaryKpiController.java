package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.model.dto.VlrSummaryKpiDto;
import com.example.monitoringNss.service.VlrSummaryKpiService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @GetMapping("exportCSv")
    public void exportCsvNetwork(HttpServletResponse httpServletResponse) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
        String fileName = "export_vslSummaryNetwork.csv";

        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename " + fileName + "");

        StatefulBeanToCsv<VlrSummaryKpiDto> writer = new StatefulBeanToCsvBuilder<VlrSummaryKpiDto>(httpServletResponse.getWriter())
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(vlrSummaryKpiService.avgDayAll());
    }

}
