package com.tave.controller.admin_role.admin;

import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> createNotice(@AuthenticationPrincipal PrincipalDetails principalDetails, @Valid @RequestBody NoticeDto.NoticePostDto noticePostDto) {
        return ResponseEntity.ok().body(noticeService.createNotice(principalDetails.getUser().getId(), noticePostDto));
    }

    @GetMapping("/getNotice")
    public ResponseEntity<?> getNotice(@RequestParam Long noticeId) {
        return ResponseEntity.ok().body(noticeService.getNotice(noticeId));
    }

    @PatchMapping("/modifyNotice")
    public ResponseEntity<?> updateNotice(@Valid @RequestBody NoticeDto.NoticePatchDto noticePatchDto) {

        return ResponseEntity.ok().body(noticeService.updateNotice(noticePatchDto));
    }

    @PostMapping(value = "/modifyNoticeImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyNoticeImages(@RequestParam Long noticeId, @RequestPart List<MultipartFile> imageList) {
        return ResponseEntity.ok().body(noticeService.updateNoticeImages(noticeId, imageList));
    }

    @DeleteMapping("/deleteNotice")
    public ResponseEntity<?> deleteNotice(@RequestParam long noticeId) {
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok().body("deleted NoticeId : " + noticeId);
    }

    @GetMapping("/getAllNotice")
    public ResponseEntity<List<NoticeDto.NoticeResponseDto>> getAllNotice() {
        List<NoticeDto.NoticeResponseDto> notices = noticeService.getAllNotice();
        return ResponseEntity.ok().body(notices);
    }

}