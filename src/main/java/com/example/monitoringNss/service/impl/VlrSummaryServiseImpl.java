package com.example.monitoringNss.service.impl;


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
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {

    private final String FALE_PPATH = "C:\\Users\\ndyykanbaev\\Desktop\\My Projects\\статистики\\VLR.csv";

    private final VlrSummaryRepo vlrSummaryRepo;

    public List<VlrSummaryDto> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest){

        return VlrSummaryMapper.INSTANCE.entityToDtoList(vlrSummaryRepo.saveAll
                        (VlrSummaryMapper.INSTANCE.requestToEntityList(createVlrSummaryRequest)));
    }

    @Override
    public void uploadVlrSummary() throws IOException, CsvException {

        CSVReader csvReader = new CSVReader(new FileReader(FALE_PPATH));

        List<String[]> rows = csvReader.readAll();
        List<VlrSummaryRequest> vlrSummaries = new ArrayList<>();

        rows.remove(0);

            for (String[] row : rows){
                VlrSummaryRequest vlrSummary = new VlrSummaryRequest();

                System.out.println("row0 LLLLLL:  " + row.length);
                System.out.println("row0 LLLLLL:  " + row[0]);
                System.out.println("row0 LLLLLL:  " + row[1]);




                System.out.println(Arrays.toString(row));
                vlrSummary.setStartTime(row[0]);
                vlrSummary.setMsxName(row[2]);
                vlrSummary.setVlrLocal(Long.valueOf(row[4]));
                vlrSummary.setVlrRoaming(Long.valueOf(row[5]));
                vlrSummary.setVlrCamel(Long.valueOf(row[6]));
                vlrSummary.setVlrCamel(Long.valueOf(row[7]));
                vlrSummary.setVlrSGs(Long.valueOf(row[9]));

                vlrSummaries.add(vlrSummary);
            }

        System.out.println(vlrSummaries);

    }

    @Override
    public List<VlrSummary> findAll() {
        return vlrSummaryRepo.findAll();
    }


}
