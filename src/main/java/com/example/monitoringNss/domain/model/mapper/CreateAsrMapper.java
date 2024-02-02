package com.example.monitoringNss.domain.model.mapper;

import com.example.monitoringNss.domain.model.entity.Asr;
import com.example.monitoringNss.domain.model.request.CreateAsrRequest;

import java.util.ArrayList;
import java.util.List;

public class CreateAsrMapper {
    public static final CreateAsrMapper INSTANCE = new CreateAsrMapper();
    public List<Asr> toEntity(List<CreateAsrRequest> createAsrRequests){

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

//    public AsrDto toDto(Asr asr){
//        return AsrDto
//                .builder()
//                .objectInstance(asr.getObjectInstance())
//                .startTime(asr.getStartTime())
//                .date(asr.getDate())
//                .time(asr.getTime())
//                .callAttemptTimes(asr.getCallAttemptTimes())
//                .answerTimes(asr.getAnswerTimes())
//                .answerRatio(asr.getAnswerRatio())
//                .abandonBeforeRingTimes(asr.getAbandonBeforeRingTimes())
//                .abandonAfterRingTimes(asr.getAbandonAfterRingTimes())
//                .ringedNoAnswerTimes(asr.getRingedNoAnswerTimes())
//                .userBusyTimes(asr.getUserBusyTimes())
//                .userDeterminatedBusyTimes(asr.getUserDeterminatedBusyTimes())
//                .invalidAddressTimes(asr.getInvalidAddressTimes())
//                .pagingNoResponseTimes(asr.getPagingNoResponseTimes())
//                .absentSubscriberTimes(asr.getAbsentSubscriberTimes())
//                .subscriberServiceRestrictedTimes(asr.getSubscriberServiceRestrictedTimes())
//                .specialSignalTonePlayedTimes(asr.getSpecialSignalTonePlayedTimes())
//                .theCalledNoRespond(asr.getTheCalledNoRespond())
//                .asr(asr.getAsr())
//                .ner(asr.getNer())
//                .sucAttempt(asr.getSucAttempt())
//                .build();
//    }
}
