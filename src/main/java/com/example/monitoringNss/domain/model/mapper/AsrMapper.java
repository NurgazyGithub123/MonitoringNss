package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.CreateAsrRequest;

import java.util.ArrayList;
import java.util.List;

public class AsrMapper {
    public static final AsrMapper INSTANCE = new AsrMapper();

    public List<AsrDto> entityToDtoList(List<Asr> asr){

        List<AsrDto> asrDtos = new ArrayList<>();
        for (Asr asrList: asr){

        AsrDto asrDto = AsrDto.builder()
                .id(asrList.getId())
                .objectInstance(asrList.getObjectInstance())
                .startTime(asrList.getStartTime())
                .date(asrList.getDate())
                .time(asrList.getTime())
                .callAttemptTimes(asrList.getCallAttemptTimes())
                .answerTimes(asrList.getAnswerTimes())
                .answerRatio(asrList.getAnswerRatio())
                .abandonBeforeRingTimes(asrList.getAbandonBeforeRingTimes())
                .abandonAfterRingTimes(asrList.getAbandonAfterRingTimes())
                .ringedNoAnswerTimes(asrList.getRingedNoAnswerTimes())
                .userDeterminatedBusyTimes(asrList.getUserDeterminatedBusyTimes())
                .userBusyTimes(asrList.getUserBusyTimes())
                .invalidAddressTimes(asrList.getSubscriberServiceRestrictedTimes())
                .pagingNoResponseTimes(asrList.getPagingNoResponseTimes())
                .absentSubscriberTimes(asrList.getAbsentSubscriberTimes())
                .subscriberServiceRestrictedTimes(asrList.getSubscriberServiceRestrictedTimes())
                .specialSignalTonePlayedTimes(asrList.getSpecialSignalTonePlayedTimes())
                .theCalledNoRespond(asrList.getTheCalledNoRespond())
                .asr(asrList.getAsr())
                .ner(asrList.getNer())
                .sucAttempt(asrList.getSucAttempt())
                .build();

            asrDtos.add(asrDto);
        }
         return asrDtos;
    }

    public AsrDto entityToDto(Asr asr){

        return AsrDto.builder()
                    .id(asr.getId())
                    .objectInstance(asr.getObjectInstance())
                    .startTime(asr.getStartTime())
                    .date(asr.getDate())
                    .time(asr.getTime())
                    .callAttemptTimes(asr.getCallAttemptTimes())
                    .answerTimes(asr.getAnswerTimes())
                    .answerRatio(asr.getAnswerRatio())
                    .abandonBeforeRingTimes(asr.getAbandonBeforeRingTimes())
                    .abandonAfterRingTimes(asr.getAbandonAfterRingTimes())
                    .ringedNoAnswerTimes(asr.getRingedNoAnswerTimes())
                    .userDeterminatedBusyTimes(asr.getUserDeterminatedBusyTimes())
                    .userBusyTimes(asr.getUserBusyTimes())
                    .invalidAddressTimes(asr.getSubscriberServiceRestrictedTimes())
                    .pagingNoResponseTimes(asr.getPagingNoResponseTimes())
                    .absentSubscriberTimes(asr.getAbsentSubscriberTimes())
                    .subscriberServiceRestrictedTimes(asr.getSubscriberServiceRestrictedTimes())
                    .specialSignalTonePlayedTimes(asr.getSpecialSignalTonePlayedTimes())
                    .theCalledNoRespond(asr.getTheCalledNoRespond())
                    .asr(asr.getAsr())
                    .ner(asr.getNer())
                    .sucAttempt(asr.getSucAttempt())
                    .build();

    }

    public List<Asr> dtoToEntityList(List<AsrDto> asrDtoList){

        List<Asr> asrList = new ArrayList<>();
        for (AsrDto asrDto : asrDtoList) {
            Asr savedAsr = Asr
                    .builder()
                    .id(asrDto.getId())
                    .objectInstance(asrDto.getObjectInstance())
                    .startTime(asrDto.getStartTime())
                    .date(asrDto.getDate())
                    .time(asrDto.getTime())
                    .callAttemptTimes(asrDto.getCallAttemptTimes())
                    .answerTimes(asrDto.getAnswerTimes())
                    .answerRatio(asrDto.getAnswerRatio())
                    .abandonBeforeRingTimes(asrDto.getAbandonBeforeRingTimes())
                    .abandonAfterRingTimes(asrDto.getAbandonAfterRingTimes())
                    .ringedNoAnswerTimes(asrDto.getRingedNoAnswerTimes())
                    .userBusyTimes(asrDto.getUserBusyTimes())
                    .userDeterminatedBusyTimes(asrDto.getUserDeterminatedBusyTimes())
                    .invalidAddressTimes(asrDto.getInvalidAddressTimes())
                    .pagingNoResponseTimes(asrDto.getPagingNoResponseTimes())
                    .absentSubscriberTimes(asrDto.getAbsentSubscriberTimes())
                    .subscriberServiceRestrictedTimes(asrDto.getSubscriberServiceRestrictedTimes())
                    .specialSignalTonePlayedTimes(asrDto.getSpecialSignalTonePlayedTimes())
                    .theCalledNoRespond(asrDto.getTheCalledNoRespond())
                    .asr(asrDto.getAsr())
                    .ner(asrDto.getNer())
                    .sucAttempt(asrDto.getSucAttempt())
                    .build();

            asrList.add(savedAsr);
        }
        return asrList;
    }

    public List<Asr> requestToEntityList(List<CreateAsrRequest> createAsrRequests){

        List<Asr> asrList = new ArrayList<>();
        for (CreateAsrRequest request : createAsrRequests){

            int suc_Attampt = request.getAnswerTimes() + request.getAbandonBeforeRingTimes() + request.getAbandonAfterRingTimes() +
                    request.getRingedNoAnswerTimes() + request.getUserDeterminatedBusyTimes() + request.getUserBusyTimes() +
                    request.getInvalidAddressTimes() + request.getPagingNoResponseTimes() + request.getAbsentSubscriberTimes() +
                    request.getSubscriberServiceRestrictedTimes() + request.getSpecialSignalTonePlayedTimes() + request.getTheCalledNoRespond();

            Asr asr = Asr
                    .builder()
                    .objectInstance(request.getObjectInstance())
                    .startTime(request.getStartTime())
                    .date(request.getStartTime().toLocalDate())
                    .time(request.getStartTime().toLocalTime())
                    .callAttemptTimes(request.getCallAttemptTimes())
                    .answerTimes(request.getAnswerTimes())
                    .answerRatio(request.getAnswerRatio())
                    .abandonBeforeRingTimes(request.getAbandonBeforeRingTimes())
                    .abandonAfterRingTimes(request.getAbandonAfterRingTimes())
                    .ringedNoAnswerTimes(request.getRingedNoAnswerTimes())
                    .userDeterminatedBusyTimes(request.getUserDeterminatedBusyTimes())
                    .userBusyTimes(request.getUserBusyTimes())
                    .invalidAddressTimes(request.getSubscriberServiceRestrictedTimes())
                    .pagingNoResponseTimes(request.getPagingNoResponseTimes())
                    .absentSubscriberTimes(request.getAbsentSubscriberTimes())
                    .subscriberServiceRestrictedTimes(request.getSubscriberServiceRestrictedTimes())
                    .specialSignalTonePlayedTimes(request.getSpecialSignalTonePlayedTimes())
                    .theCalledNoRespond(request.getTheCalledNoRespond())
                    .asr((request.getCallAttemptTimes() > 0) ? (double)request.getAnswerTimes()/ request.getCallAttemptTimes() : (double) request.getCallAttemptTimes())
                    .ner(request.getCallAttemptTimes() > 0 ?  (double) suc_Attampt / request.getCallAttemptTimes() : (double) request.getCallAttemptTimes())
                    .sucAttempt(suc_Attampt)
                    .build();

            asrList.add(asr);
        }
        return asrList;
    }
}
