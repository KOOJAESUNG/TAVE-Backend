package com.tave.controller.admin;

import com.mysql.cj.protocol.x.Notice;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("notice")
public class NoticeController {


    private final NoticeService noticeService;

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

}