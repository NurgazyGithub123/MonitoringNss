package com.example.monitoringNss.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface TestClass {


    void uploadVlrSummaryPeriod() throws SftpException, IOException, CsvException, JSchException;
}
