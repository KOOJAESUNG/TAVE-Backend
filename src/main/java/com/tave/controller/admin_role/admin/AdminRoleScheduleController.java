package com.tave.controller.admin_role.admin;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.ScheduleDto;
import com.tave.service.admin.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/schedule")
public class AdminRoleScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/createSchedule")
    public ResponseEntity<?> createSchedule(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody ScheduleDto.SchedulePostDto schedulePostDto) {
        try {
            // 서비스 레이어에서 스케줄 생성 메서드를 호출하고 결과를 받아옴
            ScheduleDto.ScheduleResponseDto createdSchedule = scheduleService.createSchedule(principalDetails.getUser().getId(), schedulePostDto);
            return ResponseEntity.ok().body(createdSchedule);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the schedule.");
        }
    }

    @GetMapping("/getSchedule")
    public ResponseEntity<?> getSchedule(@RequestParam Long scheduleId) {
        try {
            ScheduleDto.ScheduleResponseDto schedule = scheduleService.getSchedule(scheduleId);
            return ResponseEntity.ok().body(schedule);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the schedule.");
        }
    }
    @PatchMapping("/modifySchedule")
    public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDto.SchedulePatchDto schedulePatchDto) {
        try {
            ScheduleDto.ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(schedulePatchDto);
            return ResponseEntity.ok().body(updatedSchedule);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the schedule.");
        }
    }
    @DeleteMapping("/deleteSchedule")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long scheduleId) {
        try {
            scheduleService.deleteSchedule(scheduleId);
            return ResponseEntity.ok().body("Deleted ScheduleId: " + scheduleId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the schedule.");
        }
    }

    @PatchMapping("/addAttendanceMember")
    public ResponseEntity<?> addAttendanceMember(@RequestParam Long scheduleId, @RequestParam Long memberId) {
        try {
            scheduleService.addAttendanceMemberId(scheduleId, memberId);
            return ResponseEntity.ok().body("Member Id: " + memberId + " is added in Schedule Id: " + scheduleId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the member to the schedule.");
        }
    }
    @GetMapping("/getAllSchedule")
    public ResponseEntity<List<ScheduleDto.ScheduleResponseDto>> getAllSchedule() {
        try {
            List<ScheduleDto.ScheduleResponseDto> schedules = scheduleService.getAllSchedule();
            return ResponseEntity.ok().body(schedules);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }


}
