package com.example.monitoringNss.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/asrKpi")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrKpiController {
}
