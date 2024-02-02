package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.config.DateFormatToLocal;
import com.example.monitoringNss.domain.model.entity.VlrSummary;
import com.example.monitoringNss.domain.model.request.VlrSummaryRequest;
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
    public VlrSummary create(VlrSummaryRequest request) {

        LocalDateTime dateFormatToLocal = DateFormatToLocal.dateFormat(request.getStartTime());
        System.out.println(dateFormatToLocal);
        VlrSummary savedVlrSummary = new VlrSummary();
        savedVlrSummary.setStartTime(dateFormatToLocal);
        savedVlrSummary.setMsxName(request.getMsxName());
        savedVlrSummary.setVlrCamel(request.getVlrCamel());
        savedVlrSummary.setVlrLocal(request.getVlrLocal());
        savedVlrSummary.setVlrRoaming(request.getVlrRoaming());
        savedVlrSummary.setVlrSGs(request.getVlrSGs());
        savedVlrSummary.setTotal(request.getTotal());
        savedVlrSummary.setBitel(request.getTotal() - request.getVlrCamel() - request.getVlrRoaming());
        savedVlrSummary.setDate(dateFormatToLocal.toLocalDate());
        savedVlrSummary.setTime(dateFormatToLocal.toLocalTime());
        savedVlrSummary.setYear(String.valueOf(dateFormatToLocal.toLocalDate().getYear()));
        savedVlrSummary.setWeek(DateFormatToLocal.formatToWeek(request.getStartTime()));

        return vlrSummaryRepo.save(savedVlrSummary);
    }



    public List<VlrSummary> saveAll(List<VlrSummaryRequest> createVlrSummaryRequest){

        System.out.println(createVlrSummaryRequest.get(0));
        List<VlrSummary> list = new ArrayList<>();

        for (VlrSummaryRequest vlrSummary: createVlrSummaryRequest) {
            VlrSummary savedVlrSummary = new VlrSummary();
            savedVlrSummary.setStartTime(DateFormatToLocal.dateFormat(vlrSummary.getStartTime()));
            savedVlrSummary.setMsxName(vlrSummary.getMsxName());
            savedVlrSummary.setVlrCamel(vlrSummary.getVlrCamel());
            savedVlrSummary.setVlrLocal(vlrSummary.getVlrLocal());
            savedVlrSummary.setVlrRoaming(vlrSummary.getVlrRoaming());
            savedVlrSummary.setVlrSGs(vlrSummary.getVlrSGs());
            savedVlrSummary.setTotal(vlrSummary.getTotal());
            savedVlrSummary.setBitel(vlrSummary.getTotal() - vlrSummary.getVlrCamel() - vlrSummary.getVlrRoaming());
            savedVlrSummary.setDate(DateFormatToLocal.dateFormat(vlrSummary.getStartTime()).toLocalDate());
            savedVlrSummary.setTime(DateFormatToLocal.dateFormat(vlrSummary.getStartTime()).toLocalTime());
            savedVlrSummary.setYear(DateFormatToLocal.formatToYear(vlrSummary.getStartTime()));
            savedVlrSummary.setWeek(DateFormatToLocal.formatToWeek(vlrSummary.getStartTime()));

            list.add(savedVlrSummary);
        }

        return vlrSummaryRepo.saveAll(list);
    }

}
