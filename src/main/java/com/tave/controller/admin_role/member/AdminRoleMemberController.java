package com.tave.controller.admin_role.member;


import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/member")
public class AdminRoleMemberController {

    private final MemberService memberService;

    @GetMapping("/getMember")
    public ResponseEntity<?> getMember(@RequestParam Long memberId) {
        MemberDto.MemberResponseDto member = memberService.getMember(memberId);
        return ResponseEntity.ok().body(member);
    }

    @PatchMapping("/modifyMember")
    public ResponseEntity<?> updateMember(@RequestParam Long memberId, @RequestBody MemberDto.MemberPatchDto memberPatchDto) {
        MemberDto.MemberResponseDto updatedMember = memberService.updateMember(memberId, memberPatchDto);
        return ResponseEntity.ok().body(updatedMember);
    }

    @PatchMapping(value = "/modifyProfileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@RequestParam Long memberId, @RequestPart MultipartFile profileImage) {
        return ResponseEntity.ok().body(memberService.updateMemberProfileImage(memberId, profileImage));
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<?> deleteMember(@RequestParam Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("삭제된 회원 ID: " + memberId);
    }

    @GetMapping("/getMemberScore")
    public ResponseEntity<?> getTeamScore(@RequestParam Long memberId) {
        return ResponseEntity.ok().body(memberService.getMemberScore(memberId));
    }
}
