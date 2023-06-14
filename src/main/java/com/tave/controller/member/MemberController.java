package com.tave.controller.member;


import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/getmember")
    public ResponseEntity<?> getMember(@RequestParam long memberId){
        return ResponseEntity.ok().body(memberService.getMember(memberId));
    }

    @PatchMapping("/modifymember")
    public ResponseEntity<?> updateMember(@RequestBody MemberDto.MemberPatchDto memberPatchDto){
        return ResponseEntity.ok().body(memberService.updateMember(memberPatchDto));
    }

    @DeleteMapping("/deletemember")
    public ResponseEntity<?> deleteMember(@RequestParam long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("deleted MemberId : " + memberId);
    }

}
