package com.tave.controller.admin;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.AdminDto;
import com.tave.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

//    @PostMapping("/createAdmin")
//    public ResponseEntity<?> createAdmin(@RequestBody AdminDto.AdminPostDto adminPostDto) {
//        return ResponseEntity.ok().body(adminService.createAdmin(adminPostDto));
//    }

    @GetMapping("/getAdmin")
    public ResponseEntity<?> getAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails){
        return ResponseEntity.ok().body(adminService.getAdmin(principalDetails.getUser().getId()));
    }

    @PatchMapping("/modifyAdmin")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminDto.AdminPatchDto adminPatchDto){
        return ResponseEntity.ok().body(adminService.updateAdmin(adminPatchDto));
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<?> deleteAdmin(@RequestParam long adminId){
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok().body("deleted MemberId : " + adminId);
    }
}
