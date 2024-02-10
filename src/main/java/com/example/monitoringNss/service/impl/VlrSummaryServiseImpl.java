package com.example.monitoringNss.service.impl;


import com.example.monitoringNss.config.DateFormatToLocal;
import com.example.monitoringNss.config.CastToType;
import com.example.monitoringNss.domain.model.dto.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.mapper.VlrSummaryMapper;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {
    public int a = 18;
    private final String FALE_PPATH = "C:\\Users\\ndyykanbaev\\Desktop\\My Projects\\статистики\\VLR.csv";
    final File file = new File(FALE_PPATH);

    private final VlrSummaryRepo vlrSummaryRepo;

    public List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest){

        return VlrSummaryMapper.INSTANCE.entityToDtoList(vlrSummaryRepo.saveAll
                        (VlrSummaryMapper.INSTANCE.requestToEntityList(createVlrSummaryRequest)));
    }

    @Override
    public void uploadVlrSummary() throws IOException, CsvException {
        LocalDate date = DateFormatToLocal.lastDay(a);
        a--;
        log.info("НОВЫЙ ЗАПУСК date now: {}  A: {}", date, a);

        CSVReader csvReader = new CSVReader(new FileReader(file));

        List<String[]> rows = csvReader.readAll();
        List<VlrSummaryRequest> vlrSummaries = new ArrayList<>();

        rows.remove(0);

            for (String[] row : rows){

                if((String.valueOf(date)).equals(DateFormatToLocal.strDDMMYYYYtoYYYYMMDD(row[0]).substring(0,10))){
                VlrSummaryRequest vlrSummary = new VlrSummaryRequest();

                String[] str = row[0].split(",");

                    vlrSummary.setStartTime(DateFormatToLocal.strDDMMYYYYtoYYYYMMDD(str[0]));
                    vlrSummary.setMsxName(CastToType.strRmvQuotes(str[2]));
                    vlrSummary.setVlrLocal(CastToType.strToLong(str[5]));
                    vlrSummary.setVlrRoaming(CastToType.strToLong(str[6]));
                    vlrSummary.setVlrCamel(CastToType.strToLong(str[7]));
                    vlrSummary.setTotal(CastToType.strToLong(str[8]));
                    vlrSummary.setVlrSGs(CastToType.strToLong(str[10]));

                    vlrSummaries.add(vlrSummary);
                }
            }
        saveAll(vlrSummaries);

    }

    @Override
    public List<VlrSummary> findAll() {
        return vlrSummaryRepo.findAll();
    }


//    @Scheduled(cron = "*/5 * * * *")
//    @Scheduled(cron = "0/40 * * * * ?")
    @Scheduled(fixedRate = 100000)
    public void uploadScvToVlrTime(){
        System.out.println("Получение scv файл vlr_summary: " + LocalDateTime.now());
        try {
            uploadVlrSummary();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

    }

}
