package com.tave.controller.admin_role.admin;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.AdminDto;
import com.tave.service.admin.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/admin")
public class AdminRoleAdminController {

    private final AdminService adminService;

//    @PostMapping("/createAdmin")
//    public ResponseEntity<?> createAdmin(@RequestBody AdminDto.AdminPostDto adminPostDto) {
//        return ResponseEntity.ok().body(adminService.createAdmin(adminPostDto));
//    }

    @GetMapping("/getAdmin")
    public ResponseEntity<?> getAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return ResponseEntity.ok().body(adminService.getAdmin(principalDetails.getUser().getId()));
    }

    @PatchMapping("/modifyAdmin")
    public ResponseEntity<?> updateAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails, @Valid @RequestBody AdminDto.AdminPatchDto adminPatchDto) {
        return ResponseEntity.ok().body(adminService.updateAdmin(principalDetails.getUser().getId(), adminPatchDto));
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<?> deleteAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        adminService.deleteAdmin(principalDetails.getUser().getId());
        return ResponseEntity.ok().body("deleted MemberId : " + principalDetails.getUser().getId());
    }
}
