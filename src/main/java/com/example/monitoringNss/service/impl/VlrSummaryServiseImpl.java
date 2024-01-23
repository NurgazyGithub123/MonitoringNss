package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.dto.model.VlrSummaryDto;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.entity.VlrSummaryKPI;
import com.example.monitoringNss.domain.model.request.CreateVlrSummaryRequest;
import com.example.monitoringNss.domain.repository.VlrSummaryKpiRepo;
import com.example.monitoringNss.domain.repository.VlrSummaryRepo;
import com.example.monitoringNss.service.VlrSummaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VlrSummaryServiseImpl implements VlrSummaryService {

    private final VlrSummaryRepo vlrSummaryRepo;

    @Override
    public VlrSummary create(CreateVlrSummaryRequest request) {

        VlrSummary savedVlrSummary = new VlrSummary();
        savedVlrSummary.setStartTime(request.getStartTime());
        savedVlrSummary.setMsxName(request.getMsxName());
        savedVlrSummary.setVlrCamel(request.getVlrCamel());
        savedVlrSummary.setVlrLocal(request.getVlrLocal());
        savedVlrSummary.setVlrRoaming(request.getVlrRoaming());
        savedVlrSummary.setVlrSGs(request.getVlrSGs());
        savedVlrSummary.setTotal(request.getTotal());
        savedVlrSummary.setBitel(request.getTotal() - request.getVlrCamel() - request.getVlrRoaming());
        savedVlrSummary.setDate(request.getStartTime().toLocalDate());
        savedVlrSummary.setTime(request.getStartTime().toLocalTime());
        savedVlrSummary.setYear(String.valueOf(request.getStartTime().getYear()));
        savedVlrSummary.setWeek("1");

        return vlrSummaryRepo.save(savedVlrSummary);
    }



    public List<VlrSummary> saveData(List<VlrSummary> createVlrSummaryRequest){

        System.out.println(createVlrSummaryRequest);
        List<VlrSummary> list1 = new ArrayList<>();


        for (int count = 0; count < createVlrSummaryRequest.size(); count++) {
            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(createVlrSummaryRequest.get(count).getStartTime());
            savedVlrSummary.setMsxName(createVlrSummaryRequest.get(count).getMsxName());
            savedVlrSummary.setVlrCamel(createVlrSummaryRequest.get(count).getVlrCamel());
            savedVlrSummary.setVlrLocal(createVlrSummaryRequest.get(count).getVlrLocal());
            savedVlrSummary.setVlrRoaming(createVlrSummaryRequest.get(count).getVlrRoaming());
            savedVlrSummary.setVlrSGs(createVlrSummaryRequest.get(count).getVlrSGs());
            savedVlrSummary.setTotal(createVlrSummaryRequest.get(count).getTotal());
            savedVlrSummary.setBitel(createVlrSummaryRequest.get(count).getTotal() - createVlrSummaryRequest.get(count).getVlrCamel() - createVlrSummaryRequest.get(count).getVlrRoaming());
            savedVlrSummary.setDate(createVlrSummaryRequest.get(count).getStartTime().toLocalDate());
            savedVlrSummary.setTime(createVlrSummaryRequest.get(count).getStartTime().toLocalTime());
            savedVlrSummary.setYear(String.valueOf(createVlrSummaryRequest.get(count).getStartTime().getYear()));
            savedVlrSummary.setWeek("1");

            vlrSummaryRepo.save(savedVlrSummary);
            list1.add(savedVlrSummary);
            count++;
            System.out.println(count);

        }

        return list1;

    }

    private VlrSummaryDto castToVlr(VlrSummary savedVlrSummary) {
        return new VlrSummaryDto() {
            @Override
            public LocalDateTime getStartTime() {
                return savedVlrSummary.getStartTime();
            }

            @Override
            public String getMsxName() {
                return savedVlrSummary.getMsxName();
            }

            @Override
            public Long getvlrLocal() {
                return savedVlrSummary.getVlrLocal();
            }

            @Override
            public Long getvlrRoaming() {
                return savedVlrSummary.getVlrRoaming();
            }

            @Override
            public Long getVlrCamel() {
                return savedVlrSummary.getVlrCamel();
            }

            @Override
            public Long getTotal() {
                return savedVlrSummary.getTotal();
            }

            @Override
            public Long getBitel() {
                return savedVlrSummary.getBitel();
            }

            @Override
            public Long getVlrSGs() {
                return savedVlrSummary.getVlrSGs();
            }
        };
    }

}
