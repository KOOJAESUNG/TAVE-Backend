package com.tave.API.SSE;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class EmitterRepository {

    private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();

    public void addEmitter(Long clientId, SseEmitter emitter) {
        emitters.put(clientId, emitter);
    }

    public void removeEmitter(Long clientId) {
        emitters.remove(clientId);
    }

    public void sendEventToAll(String eventType, Object eventData) {
        Set<Long> closedEmitters = ConcurrentHashMap.newKeySet();

        emitters.forEach((clientId, emitter) -> {
            try {
                emitter.send(SseEmitter.event().name(eventType).data(eventData));
            } catch (Exception e) {
                closedEmitters.add(clientId);
                emitter.completeWithError(e);
            }
        });

        closedEmitters.forEach(this::removeEmitter);
    }

}
