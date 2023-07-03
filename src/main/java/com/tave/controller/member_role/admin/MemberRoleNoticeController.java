package com.tave.controller.member_role.admin;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            NoticeDto.NoticeResponseDto notice = noticeService.getNotice(noticeId);
            return ResponseEntity.ok().body(notice);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the notice.");
        }
    }

    @GetMapping("/getAllNotice")
    public ResponseEntity<List<NoticeDto.NoticeResponseDto>> getAllNotice() {
        try {
            List<NoticeDto.NoticeResponseDto> notices = noticeService.getAllNotice();
            return ResponseEntity.ok().body(notices);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}