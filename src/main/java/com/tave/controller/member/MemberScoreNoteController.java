package com.tave.controller.member;

import com.tave.dto.member.MemberScoreNoteDto;
import com.tave.service.member.MemberScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("memberScoreNote")
public class MemberScoreNoteController {

    private final MemberScoreNoteService memberScoreNoteService;

    @PostMapping("/createMemberScoreNote")
    public ResponseEntity<?> createMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto){
        return ResponseEntity.ok().body(memberScoreNoteService.createMemberScoreNote(memberScoreNotePostDto));
    }

    @GetMapping("/getMemberScoreNote")
    public ResponseEntity<?> getMemberScoreNote(@RequestParam long memberScoreNoteId){
        return ResponseEntity.ok().body(memberScoreNoteService.getMemberScoreNote(memberScoreNoteId));
    }

    @PatchMapping("/modifyMemberScoreNote")
    public ResponseEntity<?> updateMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto){
        return ResponseEntity.ok().body(memberScoreNoteService.updateMemberScoreNote(memberScoreNotePatchDto));
    }

    @DeleteMapping("/deleteMemberScoreNote")
    public ResponseEntity<?> deleteMemberScoreNote(@RequestParam long memberScoreNoteId){
        memberScoreNoteService.deleteMemberScoreNote(memberScoreNoteId);
        return ResponseEntity.ok().body("deleted MemberScoreNoteId : " + memberScoreNoteId);
    }
}