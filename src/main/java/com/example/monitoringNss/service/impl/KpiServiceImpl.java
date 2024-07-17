package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.config.DateFormatToLocal;
import com.example.monitoringNss.domain.KpiDto;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    public final String direct = "/export/home/sysm/opt/oss/server/var/fileint/pm/pmexport_";
    public final String pathNameVEPC = "HOST05_pmresult_50331649_60_202407150000_202407150100.csv";
    @Override
    public void uploadVlrSummaryPeriod() throws JSchException {
        connectSftp();
    }

    public void connectSftp() throws JSchException {

        String yesterDay = String.valueOf(LocalDate.now().minusDays(2));
        String yesterDayStr = yesterDay.replaceAll("-", "").trim();

        String host = "10.255.0.44";
        int port = 22;
        String username = "gkkuser";
        String password = "lB6TqUo8K9Atg1asuFBC!";
        String pathName = direct + yesterDayStr + "/";

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

            while ((line = bufferedReader.readLine()) != null){

                String[] data = line.split(",");
                String[] header = headers.split(",");
                String saveJson = "";

                if (data[0].isEmpty()) {
                    continue;
                }

                for (int i = 0; i < header.length; i++) {

                    StringBuilder jsonBuilder = new StringBuilder("{");

                    jsonBuilder.append("\"").append(header[i].replace("\"", ""), 0, Math.min(header[i].replace("\"", "").length(), 10)).append("\": \"").append(data[i].replace("\"", "")).append("\"");

                    jsonBuilder.append("}");

                    String jsonValue = jsonBuilder.toString();

                    saveJson = saveJson + jsonValue;

                }

                Kpi saveKpi = setKpi(data, saveJson, fileName);

                kpiRepo.save(saveKpi);
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

    public Kpi setKpi(String[] date, String gson, String fileName){

        Kpi kpi = new Kpi();
        kpi.setGranularity_period(date[1]);
        kpi.setResult_time(DateFormatToLocal.dateFormatУMDnotSS(date[0]));
        kpi.setFileName(fileName);
        kpi.setJson_value(gson);

        return kpi;
    }

    public LocalDateTime setDate(String[] data){
        if (!data[0].isEmpty()){
            return LocalDateTime.parse(data[0],sftpConfigService.formatterMin);

        }
        return LocalDateTime.now();
    }
}
