package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.model.dto.AsrDto;
import com.example.monitoringNss.model.entity.Asr;
import com.example.monitoringNss.model.request.CreateAsrRequest;
import com.example.monitoringNss.repository.AsrRepo;
import com.example.monitoringNss.service.AsrService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        asr.setObjectInstance(request.getObjectInstance());
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
    public List<Asr > getAllByNeNameAndStartTime() {
        return asrRepo.getAllByNeNameAndStartTime();
    }


}
