package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.KpiDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.entity.Kpi;
import com.example.monitoringNss.domain.model.entity.TestClassEntity;
import com.example.monitoringNss.domain.repository.KpiRepo;
import com.example.monitoringNss.service.KpiService;
import com.example.monitoringNss.service.SftpConfigService;
import com.google.gson.Gson;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KpiServiceImpl implements KpiService {

    @NonNull SftpConfigService sftpConfigService;
    @NonNull KpiRepo kpiRepo;


    public static final String host = "10.255.0.44";
    public static final int port = 22;
    public static final String userNameSftp = "gkkuser";
    public static final String passwordSftp = "lB6TqUo8K9Atg1asuFBC!";

    public final String direct = "/export/home/sysm/opt/oss/server/var/fileint/pm/pmexport_20240330/";

    public final String pathNameVEPC = "HOST05_pmresult_50331651_60_202403302000_202403302100.csv";
    @Override
    public void uploadVlrSummaryPeriod() throws JSchException {
        connectSftp();
    }

    public void connectSftp() throws JSchException {

        String host = "10.255.0.44";
        int port = 22;
        String username = "gkkuser";
        String password = "lB6TqUo8K9Atg1asuFBC!";
        String pathName = direct;

        String fileName = pathNameVEPC;

        ChannelSftp sftp = sftpConfigService.connect(host, port, username, password);
        Channel channel = sftpConfigService.connect(host, port, username, password);
        writeFileHost44(pathName, fileName, sftp, channel);
    }

    public void writeFileHost44(String pathName, String fileName, ChannelSftp sftp, Channel channel) throws JSchException {
        List<Kpi> kpis = new ArrayList<>();
        List<KpiDto> kpiDtos = new ArrayList<>();

        try {
            String line;
            InputStream stream = sftp.get(pathName + fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String headers = bufferedReader.readLine();


            while ((line = bufferedReader.readLine()) != null) {
                TestClassEntity testClass = new TestClassEntity();

                String[] data = line.split(",");
                String[] data2 = headers.split(",");


//                if (data[0].isEmpty() || Integer.parseInt(data[getIndexVlrCounter(data2)]) == 0) {
//                    continue;
//                }
                if (data[0].isEmpty()) {
                    continue;
                }

                System.out.println("NNNNNNNNNNNNNNN"  +   data[0]);
//                Kpi kpi = new Kpi();
//                kpi.setResult_time(LocalDateTime.parse(data[0]));
//                kpi.setCounterName(data[2]);
//                kpi.setFileName(fileName);
//                kpi.setGranularity_period(data[1]);

                for (int i = 0; i < 7; i++) {
                    System.out.println("data2 : index " + i + " ::::::::" + data2[i]);
                    System.out.println("data : index " + i + " ::::::::" + data[i]);
                }


//                for (int i = 4; i < data2.length; i++) {
//                    KpiDto kpiDto = new KpiDto();
//                    kpiDto.setKey(data2[i]);
//                    kpiDto.setValue(data[i + 2]);
//
//                    kpiDtos.add(kpiDto);
//                    System.out.println(kpiDtos);
//                }

                Gson gson = new Gson();
                System.out.print(gson.toJson(kpiDtos));
//                testClass.setStartTime(setDate(data));
//                testClass.setJson(data[getIndexVlrCounter(data2)]);
//
//                System.out.println(testClass);

 //               kpiRepo.save(testClass);

            }


        } catch (SftpException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Integer getIndexVlrCounter(String[] data) {

        String columnName = "50331654";

        for (int i = 0; i < data.length; i++) {
            if (data[i].contains(columnName)) {
                return i+1;
            }
        }
        return null;
    }
    public LocalDateTime setDate(String[] data){
        if (!data[0].isEmpty()){
            return LocalDateTime.parse(data[0],sftpConfigService.formatterMin);

        }
        return LocalDateTime.now();

    }


}
