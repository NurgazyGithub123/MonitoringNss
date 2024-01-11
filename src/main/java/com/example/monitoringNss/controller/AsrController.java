package com.example.monitoringNss.controller;

import com.example.monitoringNss.model.dto.AsrDto;
import com.example.monitoringNss.model.dto.AsrDto2;
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

    @NonNull AsrService asrService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateAsrRequest createAsrRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(asrService.create(createAsrRequest));
    }
    @GetMapping("/getAll")
    public List<Asr> getAll(){
        return  asrService.getAll();
    }

    @GetMapping("/getAllByNeNameAndStartTime")
    public List<AsrDto> getAllByNeNameAndStartTime(){
        return asrService.getAllByNeNameAndStartTime();
    }

    @GetMapping("/get/{id}") // http://localhost:8080/api/v1/asr/get/id(?)
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrService.getById(id));
    }

    @GetMapping("/getRegion/{region}") // http://localhost:8080/api/v1/asr/get/region(?)
    public ResponseEntity<?> getByRegion(@PathVariable String region){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrService.getAllbyRegion(region));
    }

    @GetMapping("/getAllIsEmpty/{region}") // http://localhost:8080/api/v1/asr/get/region(?)
    public ResponseEntity<?> getAllisEmpty(@PathVariable String region){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrService.getAllisEmpty(region));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmpty(@RequestBody Asr newAsr, @PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(asrService.updateByID(id, newAsr));

    }

    @GetMapping("/getAllnewKPI")
    public List<AsrDto2> getAllnewKPI(){

        return asrService.getAllnewKPI();
    }

}
