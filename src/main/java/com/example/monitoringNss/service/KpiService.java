package com.example.monitoringNss.service;

import com.jcraft.jsch.JSchException;

public interface KpiService {
    void uploadVlrSummaryPeriod() throws JSchException;
}
