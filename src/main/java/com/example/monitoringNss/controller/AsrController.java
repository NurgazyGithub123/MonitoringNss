package com.example.monitoringNss.controller;

import com.example.monitoringNss.model.entity.Asr;
import com.example.monitoringNss.model.request.CreateAsrRequest;
import com.example.monitoringNss.repository.AsrRepo;
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

    private final AsrRepo asrRepo;

    @NonNull AsrService asrService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateAsrRequest createAsrRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(asrService.create(createAsrRequest));
    }

    @GetMapping("/getAll")
    public List<Asr> getAll(){

        return   asrService.getAll();
    }

    @GetMapping("/getAllByNeNameAndStartTime")
    public List<Asr> getAllByNeNameAndStartTime(){
        return asrRepo.getAllByNeNameAndStartTime();
    }

   // find/id

    @GetMapping("/get/{id}") // http://localhost:8080/api/v1/asr/get/id(?)
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrService.getById(id));
    }

}
