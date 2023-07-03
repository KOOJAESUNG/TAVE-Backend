package com.tave.controller.admin_role.admin;
import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/notice")
public class AdminRoleNoticeController {

    private final NoticeService noticeService;

    @PostMapping("/createNotice")
    public ResponseEntity<?> createNotice(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody NoticeDto.NoticePostDto noticePostDto) {
        try {
            NoticeDto.NoticeResponseDto createdNotice = noticeService.createNotice(principalDetails.getUser().getId(), noticePostDto);
            return ResponseEntity.ok().body(createdNotice);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the notice.");
        }
    }

    @GetMapping("/getNotice")
    public ResponseEntity<?> getNotice(@RequestParam Long noticeId) {
        try {
            NoticeDto.NoticeResponseDto notice = noticeService.getNotice(noticeId);
            return ResponseEntity.ok().body(notice);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the notice.");
        }
    }

    @PatchMapping("/modifyNotice")
    public ResponseEntity<?> updateNotice(@RequestBody NoticeDto.NoticePatchDto noticePatchDto) {
        try {
            NoticeDto.NoticeResponseDto updatedNotice = noticeService.updateNotice(noticePatchDto);
            return ResponseEntity.ok().body(updatedNotice);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the notice.");
        }
    }

    @PostMapping(value = "/modifyNoticeImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyNoticeImages(@RequestParam Long noticeId, @RequestPart List<MultipartFile> imageList) {
        try {
            return ResponseEntity.ok().body(noticeService.updateNoticeImages(noticeId,imageList));
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the notice images.");
        }
    }

    @DeleteMapping("/deleteNotice")
    public ResponseEntity<?> deleteNotice(@RequestParam long noticeId) {
        try {
            noticeService.deleteNotice(noticeId);
            return ResponseEntity.ok().body("Deleted NoticeId: " + noticeId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the notice.");
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