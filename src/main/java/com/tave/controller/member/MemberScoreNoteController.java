package com.tave.controller.member;

import com.tave.dto.member.MemberScoreNoteDto;
import com.tave.service.member.MemberScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("memberScoreNote")
public class MemberScoreNoteController {

    @Autowired
    MemberScoreNoteService memberScoreNoteService;

    @PostMapping("/creatememberscorenote")
    public ResponseEntity<?> createMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto){
        return ResponseEntity.ok().body(memberScoreNoteService.createMemberScoreNote(memberScoreNotePostDto));
    }

    @GetMapping("/getmemberscorenote")
    public ResponseEntity<?> getMemberScoreNote(@RequestParam long memberScoreNoteId){
        return ResponseEntity.ok().body(memberScoreNoteService.getMemberScoreNote(memberScoreNoteId));
    }

    @PatchMapping("/modifymemberscorenote")
    public ResponseEntity<?> updateMemberScoreNote(@RequestBody MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto){
        return ResponseEntity.ok().body(memberScoreNoteService.updateMemberScoreNote(memberScoreNotePatchDto));
    }

    @DeleteMapping("/deletememberscorenote")
    public ResponseEntity<?> deleteMemberScoreNote(@RequestParam long memberScoreNoteId){
        memberScoreNoteService.deleteMemberScoreNote(memberScoreNoteId);
        return ResponseEntity.ok().body("deleted MemberScoreNoteId : " + memberScoreNoteId);
    }
}