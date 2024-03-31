package com.example.monitoringNss.service;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface TestClass {


    void uploadVlrSummaryPeriod() throws SftpException, IOException, CsvException, JSchException;
}
