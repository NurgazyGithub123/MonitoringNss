package com.example.monitoringNss.service.impl;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.mapper.AsrMapper;
import com.example.monitoringNss.domain.model.request.CreateAsrRequest;
import com.example.monitoringNss.domain.repository.AsrRepo;
import com.example.monitoringNss.service.AsrService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsrServiceImpl implements AsrService {

    @NonNull AsrRepo asrRepo;
    @Override
    public List<AsrDto> create(List<CreateAsrRequest> createAsrRequest) {

         return AsrMapper.INSTANCE.entityToDtoList(asrRepo.saveAll
                 (AsrMapper.INSTANCE.requestToEntityList(createAsrRequest)));
    }


    public List<AsrDto> updateAll(){

        List<Asr> asrList = asrRepo.findAll();
        List<Asr> savedAsr = new ArrayList<>();

        for(int i = 0; i < asrList.size(); i++) {

            Asr asr = new Asr();

            asr.setId(asrList.get(i).getId());
            asr.setStartTime(asrList.get(i).getStartTime());
            asr.setDate(asrList.get(i).getStartTime().toLocalDate());
            asr.setTime(asrList.get(i).getStartTime().toLocalTime());
            asr.setObjectInstance(asrList.get(i).getObjectInstance());
            asr.setCallAttemptTimes(asrList.get(i).getCallAttemptTimes());
            asr.setAnswerTimes(asrList.get(i).getAnswerTimes());
            asr.setAnswerRatio(asrList.get(i).getAnswerRatio());
            asr.setAbandonBeforeRingTimes(asrList.get(i).getAbandonBeforeRingTimes());
            asr.setAbandonAfterRingTimes(asrList.get(i).getAbandonAfterRingTimes());
            asr.setRingedNoAnswerTimes(asrList.get(i).getRingedNoAnswerTimes());
            asr.setUserDeterminatedBusyTimes(asrList.get(i).getUserDeterminatedBusyTimes());
            asr.setUserBusyTimes(asrList.get(i).getUserBusyTimes());
            asr.setInvalidAddressTimes(asrList.get(i).getInvalidAddressTimes());
            asr.setPagingNoResponseTimes(asrList.get(i).getPagingNoResponseTimes());
            asr.setAbsentSubscriberTimes(asrList.get(i).getAbsentSubscriberTimes());
            asr.setSubscriberServiceRestrictedTimes(asrList.get(i).getSubscriberServiceRestrictedTimes());
            asr.setSpecialSignalTonePlayedTimes(asrList.get(i).getSpecialSignalTonePlayedTimes());
            asr.setTheCalledNoRespond(asrList.get(i).getTheCalledNoRespond());

            int suc_Attampt = asrList.get(i).getAnswerTimes() + asrList.get(i).getAbandonBeforeRingTimes() + asrList.get(i).getAbandonAfterRingTimes() +
                    asrList.get(i).getRingedNoAnswerTimes() + asrList.get(i).getUserDeterminatedBusyTimes() + asrList.get(i).getUserBusyTimes() +
                    asrList.get(i).getInvalidAddressTimes() + asrList.get(i).getPagingNoResponseTimes() + asrList.get(i).getAbsentSubscriberTimes() +
                    asrList.get(i).getSubscriberServiceRestrictedTimes() + asrList.get(i).getSpecialSignalTonePlayedTimes() + asrList.get(i).getTheCalledNoRespond();

            asr.setSucAttempt(suc_Attampt);
            asr.setNer(asrList.get(i).getCallAttemptTimes() > 0 ? (double) suc_Attampt / asrList.get(i).getCallAttemptTimes()
                    : (double) asrList.get(i).getCallAttemptTimes());

            System.out.println((double) asrList.get(i).getAnswerTimes() / asrList.get(i).getCallAttemptTimes());
            asr.setAsr((asrList.get(i).getCallAttemptTimes() > 0) ? (double) asrList.get(i).getAnswerTimes()
                    / asrList.get(i).getCallAttemptTimes() : (double) asrList.get(i).getCallAttemptTimes());

            savedAsr.add(asr);
        }
        return AsrMapper.INSTANCE.entityToDtoList(asrRepo.saveAll(savedAsr));
    }

}
