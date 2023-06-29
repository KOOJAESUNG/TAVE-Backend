package com.tave.api.sse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SseService {
    private final com.tave.api.sse.EmitterService emitterService;


    @Transactional
    public Set<Long> addSseConnection(Long clientId) {
        return emitterService.addEmitter(clientId);
    }

    @Transactional
    public boolean removeSseConnection(Long clientId) {
        return emitterService.removeEmitter(clientId);
    }
}