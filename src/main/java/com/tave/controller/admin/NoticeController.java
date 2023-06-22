package com.tave.controller.admin;
import com.tave.API.SSE.EmitterRepository;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@RestController
@RequiredArgsConstructor
@RequestMapping("notice")
public class NoticeController {


    private final NoticeService noticeService;

    //SSE 기능구현추가
    private final EmitterRepository emitterRepository;
    @PostMapping("/createnotice")
    public ResponseEntity<?> createNotice(@RequestBody NoticeDto.NoticePostDto noticePostDto) {
        return ResponseEntity.ok().body(noticeService.createNotice(noticePostDto));
    }

    @GetMapping("/getnotice")
    public ResponseEntity<?> getNotice(@RequestParam long noticeId) {
        return ResponseEntity.ok().body(noticeService.getNotice(noticeId));
    }

    @PatchMapping("/modifynotice")
    public ResponseEntity<?> updateNotice(@RequestBody NoticeDto.NoticePatchDto noticePatchDto) {
        return ResponseEntity.ok().body(noticeService.updateNotice(noticePatchDto));
    }

    @DeleteMapping("/deletenotice")
    public ResponseEntity<?> deleteNotice(@RequestParam long noticeId) {
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok().body("deleted NoticeId : " + noticeId);
    }

    // SSE 연결을 설정하는 엔드포인트
    @GetMapping("/sse-connect/{clientId}")
    public ResponseEntity<SseEmitter> connectToSse(@PathVariable Long clientId) {
        SseEmitter sseEmitter = new SseEmitter();
        emitterRepository.addEmitter(clientId, sseEmitter);

        sseEmitter.onCompletion(() -> emitterRepository.removeEmitter(clientId));
        sseEmitter.onTimeout(() -> {
            emitterRepository.removeEmitter(clientId);
            sseEmitter.complete();
        });

        return ResponseEntity.ok(sseEmitter);
    }



}