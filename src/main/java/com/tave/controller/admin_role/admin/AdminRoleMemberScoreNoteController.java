package com.tave.controller.admin_role.admin;

import com.tave.dto.admin.MemberScoreNoteDto;
import com.tave.service.admin.MemberScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/memberScoreNote")
public class AdminRoleMemberScoreNoteController {

    private final MemberScoreNoteService memberScoreNoteService;

    @PostMapping("/createMemberScoreNote")
    public ResponseEntity<?> createMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto) {
        try {
            MemberScoreNoteDto.MemberScoreNoteResponseDto createdNote = memberScoreNoteService.createMemberScoreNote(memberScoreNotePostDto);
            return ResponseEntity.ok().body(createdNote);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the member score note.");
        }
    }

    @GetMapping("/getMemberScoreNote")
    public ResponseEntity<?> getMemberScoreNote(@RequestParam Long memberScoreNoteId) {
        try {
            MemberScoreNoteDto.MemberScoreNoteResponseDto note = memberScoreNoteService.getMemberScoreNote(memberScoreNoteId);
            return ResponseEntity.ok().body(note);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the member score note.");
        }
    }

    @PatchMapping("/modifyMemberScoreNote")
    public ResponseEntity<?> updateMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        try {
            MemberScoreNoteDto.MemberScoreNoteResponseDto updatedNote = memberScoreNoteService.updateMemberScoreNote(memberScoreNotePatchDto);
            return ResponseEntity.ok().body(updatedNote);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the member score note.");
        }
    }

    @DeleteMapping("/deleteMemberScoreNote")
    public ResponseEntity<?> deleteMemberScoreNote(@RequestParam Long memberScoreNoteId) {
        try {
            memberScoreNoteService.deleteMemberScoreNote(memberScoreNoteId);
            return ResponseEntity.ok().body("Deleted MemberScoreNoteId: " + memberScoreNoteId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the member score note.");
        }
    }
}