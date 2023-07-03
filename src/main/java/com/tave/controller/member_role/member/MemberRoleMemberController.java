package com.tave.controller.member_role.member;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

//    @PostMapping("/createMember")
//    public ResponseEntity<?> createMember(@RequestBody MemberDto.MemberPostDto memberPostDto) {
//        return ResponseEntity.ok().body(memberService.createMember(memberPostDto));
//    }

    @GetMapping("/getMember")
    public ResponseEntity<?> getMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        try {
            MemberDto.MemberResponseDto member = memberService.getMember(principalDetails.getUser().getId());
            return ResponseEntity.ok().body(member);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/modifyMember")
    public ResponseEntity<?> updateMember(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody MemberDto.MemberPatchDto memberPatchDto) {
        try {
            MemberDto.MemberResponseDto updatedMember = memberService.updateMember(principalDetails.getUser().getId(), memberPatchDto);
            return ResponseEntity.ok().body(updatedMember);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping(value = "/modifyProfileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestPart MultipartFile profileImage) {
        try {
            return ResponseEntity.ok().body(memberService.updateMemberProfileImage(principalDetails.getUser().getId(), profileImage));
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<?> deleteMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        try {
            memberService.deleteMember(principalDetails.getUser().getId());
            return ResponseEntity.ok().body("deleted MemberId : " + principalDetails.getUser().getId());
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
