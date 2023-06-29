package com.tave.api.sse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SseService {
    private final com.tave.api.sse.EmitterService emitterService;


    @Transactional
    public SseDto addSseConnection(Long clientId) {
        return SseDto.builder().joinedMembers(emitterService.addEmitter(clientId)).build();
    }

    @Transactional
    public boolean removeSseConnection(Long clientId) {
        return emitterService.removeEmitter(clientId);
    }
}