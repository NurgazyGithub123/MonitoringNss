package com.example.monitoringNss.controller;


import com.example.monitoringNss.exception.EntityNotFoundException;
import com.example.monitoringNss.service.AsrKpiService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/asrFindByDate/{date}")
    public ResponseEntity<?> asrFindByDate(@PathVariable String date){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrKpiService.asrFindByDate(date));
    }

    @GetMapping("/asrFindById/{id}")
    public ResponseEntity<?> asrFindById(@PathVariable Long id) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(asrKpiService.asrFindByID(id));
    }
}
