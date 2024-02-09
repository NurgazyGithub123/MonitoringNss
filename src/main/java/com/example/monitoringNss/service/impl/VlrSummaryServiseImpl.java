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
import org.springframework.stereotype.Service;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {


    private final String FALE_PPATH = "C:\\Users\\ndyykanbaev\\Desktop\\My Projects\\статистики\\VLR.csv";
    File file = new File(FALE_PPATH);

    private final VlrSummaryRepo vlrSummaryRepo;

    public List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest){

        return VlrSummaryMapper.INSTANCE.entityToDtoList(vlrSummaryRepo.saveAll
                        (VlrSummaryMapper.INSTANCE.requestToEntityList(createVlrSummaryRequest)));
    }

    @Override
    public void uploadVlrSummary() throws IOException, CsvException {


       CSVReader csvReader = new CSVReader(new FileReader(file));


        List<String[]> rows = csvReader.readAll();

        List<VlrSummaryRequest> vlrSummaries = new ArrayList<>();

        rows.remove(0);

            for (String[] row : rows){
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

        saveAll(vlrSummaries);

    }

    @Override
    public List<VlrSummary> findAll() {
        return vlrSummaryRepo.findAll();
    }

}
