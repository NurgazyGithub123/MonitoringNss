package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.entity.TestClassEntity;
import com.example.monitoringNss.domain.repository.TestClassRepo;
import com.example.monitoringNss.service.SftpConfigService;
import com.example.monitoringNss.service.TestClass;
import com.jcraft.jsch.*;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;



@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestClassImpl implements TestClass {

    @NonNull SftpConfigService sftpConfigService;
    @NonNull TestClassRepo testClassRepo;

//    String jdbcURL = "jdbc:postgresql://localhost:5432/testasr";
//
//    String userName = "postgres";
//
//    String password = "1234";

    public static final String host = "10.255.0.44";
    public static final int port = 22;
    public static final String userNameSftp = "gkkuser";
    public static final String passwordSftp = "lB6TqUo8K9Atg1asuFBC!";

    public final String direct = "/export/home/sysm/opt/oss/server/var/fileint/pm/pmexport_20240303/";

    public final String pathNameVEPC = "HOST05_pmresult_50331648_60_202403030000_202403030100.csv";

//    public Connection setConnectionToDb() throws SQLException {
//        return DriverManager.getConnection(jdbcURL, userName, password);
//    }
public void connectSftp() throws JSchException {

    String host = "10.255.0.44";
    int port = 22;
    String username = "gkkuser";
    String password = "lB6TqUo8K9Atg1asuFBC!";
    String pathName = direct;

    String fileName = pathNameVEPC;

    ChannelSftp sftp = sftpConfigService.connect(host, port, username, password);
    Channel channel = sftpConfigService.connect(host, port, username, password);
    writeFileVlr(pathName, fileName, sftp, channel);
}

    public void writeFileVlr(String pathName, String fileName, ChannelSftp sftp, Channel channel) throws JSchException {
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
                if (data[0].isEmpty() || Integer.parseInt(data[getIndexVlrCounter(data2)]) == 0) {
                    continue;
                }


               // testClassRepo.save(testClass);






//                TestClassEntity vlrDb = new TestClassEntity();
//                String[] data = line.split(",");
//                String[] data2 = headers.split(",");
//                if (data[0].isEmpty() || Integer.parseInt(data[getIndexVlrCounter(data2)]) == 0) {
//                    continue;
//                }
//                vlrDb.setResultTime(setDate(data));
//                vlrDb.setFileName(fileName);
//                vlrDb.setCountKpi(Integer.valueOf(data[getIndexVlrCounter(data2)]));
//
//                vlrDb.setRegion(getRegion(data));
//                testClassRepo.save(vlrDb);
            }

        } catch (Exception writeFileVlr) {
            log.error(writeFileVlr.getMessage());
        }finally {
            Session session = channel.getSession();
            session.disconnect();
            sftp.disconnect();
        }

    }

    public List<String> getDirectory() throws SftpException {
        List<String> matchingFiles = new ArrayList<>();
        ChannelSftp sftp = sftpConfigService.connect(host, port, userNameSftp, passwordSftp);

        Vector<ChannelSftp.LsEntry> fileList = sftp.ls(direct);

        for (ChannelSftp.LsEntry entry : fileList) {
            if (entry.getFilename().matches(pathNameVEPC)){
                matchingFiles.add(entry.getFilename());

            }
        }

        return matchingFiles;
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

    @Override
    public void uploadVlrSummaryPeriod() throws JSchException {
        connectSftp();
       // getDirectory();
    }
}
