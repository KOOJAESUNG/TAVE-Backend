package com.tave.controller.admin_role.member;


import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        try {
            MemberDto.MemberResponseDto member = memberService.getMember(memberId);
            return ResponseEntity.ok().body(member);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the member information.");
        }
    }

    @PatchMapping("/modifyMember")
    public ResponseEntity<?> updateMember(@RequestParam Long memberId, @RequestBody MemberDto.MemberPatchDto memberPatchDto) {
        try {
            MemberDto.MemberResponseDto updatedMember = memberService.updateMember(memberId, memberPatchDto);
            return ResponseEntity.ok().body(updatedMember);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the member information.");
        }
    }

    @PatchMapping(value = "/modifyProfileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@RequestParam Long memberId, @RequestPart MultipartFile profileImage) {
        try {
            return ResponseEntity.ok().body(memberService.updateMemberProfileImage(memberId, profileImage));
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the member's profile image.");
        }
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<?> deleteMember(@RequestParam Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("deleted MemberId : " + memberId);
    }

    @GetMapping("/getMemberScore")
    public ResponseEntity<?> getMemberScore(Long memberId) {
        return ResponseEntity.ok().body(memberService.getMemberScore(memberId));
    }

}
