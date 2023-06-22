package com.tave.controller.member;


import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/getmember")
    public ResponseEntity<?> getMember(@RequestParam long memberId){
        return ResponseEntity.ok().body(memberService.getMember(memberId));
    }

    @PatchMapping(value = "/modifymember")
    public ResponseEntity<?> updateMember(@RequestPart(value = "dto") MemberDto.MemberPatchDto memberPatchDto, @RequestPart(value = "profileImage") MultipartFile profileImage) {
        System.out.println("1");
        return ResponseEntity.ok().body(memberService.updateMember(memberPatchDto,profileImage));
    }

    @DeleteMapping("/deletemember")
    public ResponseEntity<?> deleteMember(@RequestParam long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("deleted MemberId : " + memberId);
    }

}
