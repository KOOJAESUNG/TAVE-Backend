package com.tave.controller.admin_role.admin;

import com.tave.dto.admin.MemberScoreNoteDto;
import com.tave.service.admin.MemberScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/memberScoreNote")
public class AdminRoleMemberScoreNoteController {

    private final MemberScoreNoteService memberScoreNoteService;

    @PostMapping("/createMemberScoreNote")
    public ResponseEntity<?> createMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto) {
        MemberScoreNoteDto.MemberScoreNoteResponseDto createdNote = memberScoreNoteService.createMemberScoreNote(memberScoreNotePostDto);
        return ResponseEntity.ok().body(createdNote);
    }

    @GetMapping("/getMemberScoreNote")
    public ResponseEntity<?> getMemberScoreNote(@RequestParam Long memberScoreNoteId) {
        MemberScoreNoteDto.MemberScoreNoteResponseDto note = memberScoreNoteService.getMemberScoreNote(memberScoreNoteId);
        return ResponseEntity.ok().body(note);
    }

    @PatchMapping("/modifyMemberScoreNote")
    public ResponseEntity<?> updateMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        MemberScoreNoteDto.MemberScoreNoteResponseDto updatedNote = memberScoreNoteService.updateMemberScoreNote(memberScoreNotePatchDto);
        return ResponseEntity.ok().body(updatedNote);
    }

    @DeleteMapping("/deleteMemberScoreNote")
    public ResponseEntity<?> deleteMemberScoreNote(@RequestParam Long memberScoreNoteId) {
        memberScoreNoteService.deleteMemberScoreNote(memberScoreNoteId);
        return ResponseEntity.ok().body("삭제된 회원 점수 노트 ID: " + memberScoreNoteId);
    }
}