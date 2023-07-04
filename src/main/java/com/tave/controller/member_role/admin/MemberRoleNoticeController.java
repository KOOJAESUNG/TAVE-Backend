package com.tave.controller.member_role.admin;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("memberRole/notice")
public class MemberRoleNoticeController {

    private final NoticeService noticeService;

    @GetMapping("/getNotice")
    public ResponseEntity<?> getNotice(@RequestParam Long noticeId) {
        return ResponseEntity.ok().body(noticeService.getNotice(noticeId));
    }

    @GetMapping("/getAllNotice")
    public ResponseEntity<List<NoticeDto.NoticeResponseDto>> getAllNotice() {
        List<NoticeDto.NoticeResponseDto> notices = noticeService.getAllNotice();
        return ResponseEntity.ok().body(notices);
    }

}