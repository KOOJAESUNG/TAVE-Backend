package com.tave.api.sse;

import com.tave.dto.admin.NoticeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
@Slf4j
public class SseService {

    private static final Long TIMEOUT = 60 * 60 * 1000L; //1시간
//    private static final Long TIMEOUT = -1L; //무제한

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public Boolean listIsEmpty() {
        return emitters.isEmpty();
    }

    public SseEmitter addSseConnection() {

        SseEmitter sseEmitter = new SseEmitter(TIMEOUT);

        /**
         * 연결 직후 dummy 데이터 송신
         */
        try {
            sseEmitter.send(SseEmitter.event()
                    .name("connect")
                    .data("connected!"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * 만료, 타임아웃, 에러 상황에 대한 처리.
         * 별개의 쓰레드에서 작동하므로 emitters는 thread-safe한 자료구조를 사용해야 한다.
         */
        sseEmitter.onCompletion(() -> {
            log.info("onCompletion callback");
            this.emitters.remove(sseEmitter);
        });
        sseEmitter.onTimeout(() -> {
            log.info("onTimeout callback");
            sseEmitter.complete();
        });
        sseEmitter.onError(e -> {
            log.info("onError callback");
            sseEmitter.complete();
        });

        /**
         * emitters에 생성한 sseEmitter를 추가. 알림이 갈 수 있도록 한다.
         */
        emitters.add(sseEmitter);

        /**
         * log 출력
         */
        log.info("new emitter added: {}", sseEmitter);
        log.info("emitter list size: {}", emitters.size());
        log.info("emitter list: {}", emitters);

        return sseEmitter;
    }


    public void sendEventToAll(String eventType, NoticeDto.NoticeResponseDto noticeResponseDto) {
        /**
         * 모든 emitter에 notice 보내기
         */
        emitters.forEach((emitter) -> {
            try {
                emitter.send(SseEmitter.event().name(eventType).data(noticeResponseDto));
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });
    }

    @Scheduled(fixedDelay = 60*1000) //1분마다 실행
    public void checkConnectToAll() {
        /**
         * check Connection
         */
        if (!emitters.isEmpty()) {
            emitters.forEach((emitter) -> {
                try {
                    emitter.send(SseEmitter.event().name("checkConnect").data("connected!"));
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            });
        }
    }
}