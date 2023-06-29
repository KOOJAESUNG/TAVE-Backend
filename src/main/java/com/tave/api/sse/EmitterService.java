package com.tave.api.sse;
import com.tave.dto.admin.NoticeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




@Component
@Slf4j
public class EmitterService {

    private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();
//    private final List<MemberDto.MemberResponseDto> members = new ArrayList<>();


    public SseEmitter addEmitter(Long clientId) {

        SseEmitter sseEmitter = new SseEmitter(); //연결 무제한 설정
        try {
            sseEmitter.send(SseEmitter.event()
                    .name("connect")
                    .data("connected!"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        emitters.put(clientId, sseEmitter);
        return sseEmitter;
    }

    public String removeEmitter(Long clientId) {
        emitters.remove(clientId);
        return "remove complete";
    }

    public void sendEventToAll(String eventType, NoticeDto.NoticeResponseDto noticeResponseDto) {
        /**
         * emitter에 notice 보내기
         */
        emitters.forEach((clientId, emitter) -> {
            try {
                emitter.send(SseEmitter.event().name(eventType).data(noticeResponseDto));
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });

//        /**
//         * 모든 멤버에게 공지사항 보내기
//         */
//        for (MemberDto.MemberResponseDto member : members) {
//            try {
//                // 멤버에게 이벤트 보내는 로직 작성
//                SseEmitter memberEmitter = emitters.get(member.getId());
//                if (memberEmitter != null) {
//                    memberEmitter.send(SseEmitter.event().name(eventType).data(noticeResponseDto));
//                }
//            } catch (Exception e) {
//                log.error("멤버에게 이벤트 보내는 중 에러: {}", member.getId(), e);
//            }
//        }


    }

}