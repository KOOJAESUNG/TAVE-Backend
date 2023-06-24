package com.tave.controller.admin;
import com.tave.api.SSE.EmitterRepository;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("notice")
public class NoticeController {

    private final NoticeService noticeService;

    //SSE 기능구현추가
    private final EmitterRepository emitterRepository;
    @PostMapping("/createNotice")
    public ResponseEntity<?> createNotice(@RequestBody NoticeDto.NoticePostDto noticePostDto) {
        return ResponseEntity.ok().body(noticeService.createNotice(noticePostDto));
    }

    @GetMapping("/getNotice")
    public ResponseEntity<?> getNotice(@RequestParam long noticeId) {
        return ResponseEntity.ok().body(noticeService.getNotice(noticeId));
    }

    @PatchMapping("/modifyNotice")
    public ResponseEntity<?> updateNotice(@RequestBody NoticeDto.NoticePatchDto noticePatchDto) {

        return ResponseEntity.ok().body(noticeService.updateNotice(noticePatchDto));
    }

    @PostMapping(value = "/modifyNoticeImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyNoticeImages(@RequestParam Long noticeId, @RequestPart List<MultipartFile> imageList) {
        return ResponseEntity.ok().body(noticeService.updateNoticeImages(noticeId,imageList));
    }

    @DeleteMapping("/deleteNotice")
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