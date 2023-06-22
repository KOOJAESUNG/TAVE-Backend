package com.tave.controller.member;


import com.tave.dto.member.MemberDto;
import com.tave.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/getmember")
    public ResponseEntity<?> getMember(@RequestParam long memberId){
        return ResponseEntity.ok().body(memberService.getMember(memberId));
    }

    @PatchMapping("/modifymember")
    public ResponseEntity<?> updateMember(@RequestBody MemberDto.MemberPatchDto memberPatchDto) {
        return ResponseEntity.ok().body(memberService.updateMember(memberPatchDto));
    }

    @PatchMapping(value = "/modifyprofileimage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMemberProfileImage(@RequestParam Long memberId, @RequestPart MultipartFile profileImage) {
        return ResponseEntity.ok().body(memberService.updateMemberProfileImage(memberId,profileImage));
    }

    @DeleteMapping("/deletemember")
    public ResponseEntity<?> deleteMember(@RequestParam long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().body("deleted MemberId : " + memberId);
    }

}
