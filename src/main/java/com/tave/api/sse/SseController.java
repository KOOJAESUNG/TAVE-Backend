package com.tave.api.sse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("sse")
public class SseController {
    private final com.tave.api.sse.SseService sseService;


    // Sse연결을 설정하는 엔드포인트
    @GetMapping(value = "/connect/{clientId}")
    public ResponseEntity<SseDto> addSseConnection(@PathVariable Long clientId) {
        return ResponseEntity.ok().body(sseService.addSseConnection(clientId));
    }


    // Sse 연결을 제거하는 엔드포인트
    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<?> removeSseConnection(@PathVariable Long clientId) {
        return ResponseEntity.ok().body(sseService.removeSseConnection(clientId));
    }

}