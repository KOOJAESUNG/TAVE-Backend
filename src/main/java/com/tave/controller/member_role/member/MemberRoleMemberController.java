package com.tave.controller.member_role.member;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("memberRole/member")
public class MemberRoleMemberController {

    private final MemberService memberService;

    @GetMapping("/getMember")
    public ResponseEntity<?> getMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
            MemberDto.MemberResponseDto member = memberService.getMember(principalDetails.getUser().getId());
            return ResponseEntity.ok().body(member);
    }

    @PatchMapping("/modifyMember")
    public ResponseEntity<?> updateMember(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody MemberDto.MemberPatchDto memberPatchDto) {
            MemberDto.MemberResponseDto updatedMember = memberService.updateMember(principalDetails.getUser().getId(), memberPatchDto);
            return ResponseEntity.ok().body(updatedMember);
    }

    @PatchMapping(value = "/modifyProfileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestPart MultipartFile profileImage) {
            return ResponseEntity.ok().body(memberService.updateMemberProfileImage(principalDetails.getUser().getId(), profileImage));
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<?> deleteMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
            memberService.deleteMember(principalDetails.getUser().getId());
            return ResponseEntity.ok().body("deleted MemberId : " + principalDetails.getUser().getId());
    }

    @GetMapping("/getMemberScore")
    public ResponseEntity<?> getTeamScore(@RequestParam Long memberId) {
            return ResponseEntity.ok().body(memberService.getMemberScore(memberId));
    }
}
