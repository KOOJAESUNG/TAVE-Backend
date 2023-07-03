package com.tave.controller.admin_role.admin;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.AdminDto;
import com.tave.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            AdminDto.AdminResponseDto admin = adminService.getAdmin(principalDetails.getUser().getId());
            return ResponseEntity.ok().body(admin);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the admin details.");
        }
    }

    @PatchMapping("/modifyAdmin")
    public ResponseEntity<?> updateAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody AdminDto.AdminPatchDto adminPatchDto) {
        try {
            AdminDto.AdminResponseDto updatedAdmin = adminService.updateAdmin(principalDetails.getUser().getId(), adminPatchDto);
            return ResponseEntity.ok().body(updatedAdmin);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the admin.");
        }
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<?> deleteAdmin(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        try {
            adminService.deleteAdmin(principalDetails.getUser().getId());
            return ResponseEntity.ok().body("Deleted MemberId: " + principalDetails.getUser().getId());
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the admin.");
        }
    }
}
