package com.tave.controller.admin;


import com.tave.dto.admin.AdminDto;
import com.tave.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {


    private final AdminService adminService;

    @GetMapping("/getadmin")
    public ResponseEntity<?> getAdmin(@RequestParam long adminId){
        return ResponseEntity.ok().body(adminService.getAdmin(adminId));
    }

    @PatchMapping("/modifymember")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminDto.AdminPatchDto adminPatchDto){
        return ResponseEntity.ok().body(adminService.updateAdmin(adminPatchDto));
    }

    @DeleteMapping("/deletemember")
    public ResponseEntity<?> deleteAdmin(@RequestParam long adminId){
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok().body("deleted MemberId : " + adminId);
    }
}
