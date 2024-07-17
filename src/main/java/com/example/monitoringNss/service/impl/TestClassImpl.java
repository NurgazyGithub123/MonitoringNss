package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.entity.Kpi;
import com.example.monitoringNss.domain.model.entity.TestClassEntity;
import com.example.monitoringNss.domain.repository.KpiRepo;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestClassImpl implements TestClass {

    @NonNull SftpConfigService sftpConfigService;
    @NonNull TestClassRepo testClassRepo;
    @NonNull KpiRepo kpiRepo;


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
//                if (data[0].isEmpty() || Integer.parseInt(data[getIndexVlrCounter(data2)]) == 0) {
//                    continue;
//                }


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

//    public TestClassEntity getIndexVlrCounter(String counterName) {
//    List<TestClassEntity> testClassEntities = new ArrayList<>();
//    List<Kpi> kpiList = kpiRepo.findAll();
//
//
//        for (int i = 0; i < kpiList.size(); i++) {
//            if (kpiList.get(i).getJson_value().contains(counterName)) {
//                TestClassEntity testClass = new TestClassEntity();
//                testClass.setStartTime(kpiList.get(i).getResult_time());
//                testClass.setCounterName(counterName);
//                testClass.setCounterValues(kpiList.get(i).getJson_value().matches([^counterName]);
//
//            }
//        }
//
//        testClassRepo.saveAll(testClassEntities);
//        return null;
//    }

    @Override
    public void uploadVlrSummaryPeriod() throws JSchException {

    List<Kpi> kpi = kpiRepo.findAll();

    for (Kpi saveKpi : kpi){
        TestClassEntity testClass = new TestClassEntity();
        testClass.setStartTime(saveKpi.getResult_time());
        testClass.setCounterName("50332580");
        testClass.setCounterValues(castJsonToCounterValue(saveKpi.getJson_value(), "50332580"));

        testClassRepo.save(testClass);
    }


        //connectSftp();
       // getDirectory();

        //getIndexVlrCounter("1526727189");
    }

    public String castJsonToCounterValue(String json, String counterName) {

        String str = "{\"Result Tim\": \"2024-07-15 12:30\"}{\"Granularit\": \"15\"}{\"Object Nam\": \"KarBu7sLW/S1Interface:eNodeB Function Name=KarBu7sWL\"}{\"Reliabilit\": \" S1Interface ID=40000\"}{\"1526727188\": \"Reliable\"}{\"1526727189\": \"0\"}";
        String[] str1 = json.split(": \"");
        boolean isTrue = false;
        int counter = 0;

        for (int i = 0; i < str1.length; i++) {

            String text = str1[i];
            Pattern p = Pattern.compile(counterName + "+?");
            Matcher m = p.matcher(str1[i]);

            String test = "";

            while (m.find()) {
                test = str1[i].substring(m.start(), m.end());
            }

            System.out.println(test);

            if (counterName.equals(test)) {
                isTrue = true;
                counter = i;
                System.out.println(counter);
            }
        }

        String b = str1[counter + 1];
        String[] fin = b.split("\"");

        return fin[0];
    }
}
