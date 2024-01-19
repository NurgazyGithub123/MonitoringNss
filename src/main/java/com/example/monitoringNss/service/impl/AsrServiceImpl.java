package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.dto.model.AsrDto;
import com.example.monitoringNss.domain.dto.model.AsrDto2;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.CreateAsrRequest;
import com.example.monitoringNss.domain.repository.AsrRepo;
import com.example.monitoringNss.service.AsrService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrServiceImpl implements AsrService {

    @NonNull AsrRepo asrRepo;



    public Asr create(CreateAsrRequest request){
        Asr asr = new Asr();
        asr.setNeName(request.getNeName());
        asr.setStartTime(request.getStartTime());
        asr.setLocalSubscribers(request.getLocalSubscribers());
        asr.setRoamingSubscribers(request.getRoamingSubscribers());

        return asrRepo.save(asr);
    }

    @Override
    public Asr getById(Long id){
        return asrRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Asr with id = " + id + "not found"));
    }
    @Override
    public List<Asr> getAll() {
        return asrRepo.findAll();


    }

    @Override
    public List<AsrDto> getAllByNeNameAndStartTime() {
        return asrRepo.getAllByNeNameAndStartTime();
    }

    @Override
    public List<Asr> getAllbyRegion(String region) {
        String str = region.trim();
        if(str.isEmpty()){
            region = "Бишкек";
        }
        return asrRepo.getAllbyRegion(region);
    }

    @Override
    public List<Asr> getAllisEmpty(String region) {
        String str = region.trim();
        if(str.isEmpty()){
           return asrRepo.findAll();
        }
        return getAllbyRegion(region);
    }

    @Override
    public Asr updateByID(Long id, Asr newAsr) {
        Asr upAsr = asrRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Asr with id = " + id + "not found"));

        Asr asr = new Asr();
        asr.setId(upAsr.getId());
        asr.setNeName(newAsr.getNeName());
        asr.setRnc(newAsr.getRnc());
        asr.setRegion(newAsr.getRegion());
        asr.setLocalSubscribers(newAsr.getLocalSubscribers());
        asr.setRoamingSubscribers(newAsr.getRoamingSubscribers());
        asr.setStartTime(upAsr.getStartTime());

        return asrRepo.save(asr);
    }

    @Override
    public List<AsrDto2> getAllnewKPI() {
         return asrRepo.getAllnewKPI();
    }

        @Override
    public List<AsrDto2> getAllnewKPI2() {
        List<AsrDto2> asrs = asrRepo.getAllnewKPI2();
        List<AsrDto2> savedAsr = new ArrayList<>();

            for (AsrDto2 asr: asrs) {
                Asr asr1 = new Asr();
                asr1.setId(asr.getId());
                asr1.setStartTime(asr.getStartTime());
                asr1.setNeName(asr.getNeName());
                asr1.setLocalSubscribers(asr.getLocalSubscribers() *2);
                asr1.setRegion(asr.getRegion());

                savedAsr.add(castToAsr(asr1));

            }
            return savedAsr;
    }

    private AsrDto2 castToAsr(Asr asr){
                return new AsrDto2() {
                    @Override
            public Long getId() {
                return asr.getId();
            }

            @Override
            public LocalDateTime getStartTime() {
                return asr.getStartTime();
            }

            @Override
            public String getNeName() {
                return asr.getNeName();
            }

            @Override
            public String getRegion() {
                return asr.getRegion();
            }

            @Override
            public Long getLocalSubscribers() {
                return asr.getLocalSubscribers();
            }
        };
    }

}
