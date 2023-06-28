package com.tave.API.SSE;

import com.tave.domain.member.MemberEntity;
import com.tave.dto.member.MemberDto;
import com.tave.repository.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("sse")
public class SseController {
    private final SseService sseService;


    // Sse연결을 설정하는 엔드포인트
    @PatchMapping("/connect/{clientId}")
    public ResponseEntity<?> addSseConnection(@PathVariable Long clientId) {
        return ResponseEntity.ok().body(sseService.addSseConnection(clientId));
    }


    // Sse 연결을 제거하는 엔드포인트
    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<?> removeSseConnection(@PathVariable Long clientId) {
        return ResponseEntity.ok().body(sseService.removeSseConnection(clientId));
    }

}