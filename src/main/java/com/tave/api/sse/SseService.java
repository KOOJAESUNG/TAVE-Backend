package com.tave.api.sse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
public class SseService {
    private final com.tave.api.sse.EmitterService emitterService;

    @Transactional
    public SseEmitter addSseConnection(Long clientId) {
        return emitterService.addEmitter(clientId);
    }

    @Transactional
    public String removeSseConnection(Long clientId) {
        return emitterService.removeEmitter(clientId);
    }
}