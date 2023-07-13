package com.tave.controller.admin_role.member;


import com.tave.dto.member.MemberDto;
import com.tave.dto.team.TeamDto;
import com.tave.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/member")
public class AdminRoleMemberController {

    private final MemberService memberService;

//    @PostMapping("/createMember")
//    public ResponseEntity<?> createMember(@RequestBody MemberDto.MemberPostDto memberPostDto) {
//        return ResponseEntity.ok().body(memberService.createMember(memberPostDto));
//    }

    @GetMapping("/getMember")
    public ResponseEntity<?> getMember(@RequestParam Long memberId) {
        return ResponseEntity.ok().body(memberService.getMember(memberId));
    }

    @PatchMapping("/modifyMember")
    public ResponseEntity<?> updateMember(@RequestParam Long memberId, @Valid @RequestBody MemberDto.MemberPatchDto memberPatchDto) {
        return ResponseEntity.ok().body(memberService.updateMember(memberId, memberPatchDto));
    }

    @PatchMapping(value = "/modifyProfileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@RequestParam Long memberId, @RequestPart MultipartFile profileImage) {
        return ResponseEntity.ok().body(memberService.updateMemberProfileImage(memberId, profileImage));
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<?> deleteMember(@RequestParam Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("deleted MemberId : " + memberId);
    }

    @GetMapping("/getMemberScore")
    public ResponseEntity<?> getMemberScore(Long memberId) {
        return ResponseEntity.ok().body(memberService.getMemberScore(memberId));
    }

    @GetMapping("/getAllMember")
    public ResponseEntity<List<MemberDto.MemberResponseDto>> getAllMember(){
        List<MemberDto.MemberResponseDto> member= memberService.getAllMember();
        return ResponseEntity.ok().body(member);
    }

}
