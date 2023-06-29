package com.tave.API.SSE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SseService {
    private final EmitterService emitterService;


    @Transactional
    public Set<Long> addSseConnection(Long clientId) {
        return emitterService.addEmitter(clientId);
    }

    @Transactional
    public boolean removeSseConnection(Long clientId) {
        return emitterService.removeEmitter(clientId);
    }
}
