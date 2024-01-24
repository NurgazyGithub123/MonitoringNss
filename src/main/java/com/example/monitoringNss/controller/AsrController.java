package com.example.monitoringNss.controller;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.AsrRequest;
import com.example.monitoringNss.service.AsrService;
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
@RequestMapping("/api/v1/asr")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrController {

        @NonNull AsrService asrService;

        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody @Validated List<AsrRequest> asrRequest){
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(asrService.create(asrRequest));
        }

        @PutMapping("/update")
        public ResponseEntity<?> updateById(){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(asrService.updateAll());

        }



}
