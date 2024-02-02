package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.dto.AsrDto;
import com.example.monitoringNss.domain.model.entity.Asr;

import java.util.ArrayList;
import java.util.List;

public class AsrMapper {
    public static final AsrMapper INSTANCE = new AsrMapper();

    public List<AsrDto> toDto(List<Asr> asr){

        List<AsrDto> asrDtos = new ArrayList<>();
        for (Asr asrList: asr){

        AsrDto asrDto = AsrDto.builder()
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

    public List<Asr> toEntity(List<AsrDto> asrDtoList){

        List<Asr> asrList = new ArrayList<>();
        for (AsrDto asrDto : asrDtoList) {
            Asr savedAsr = Asr
                    .builder()
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
}
