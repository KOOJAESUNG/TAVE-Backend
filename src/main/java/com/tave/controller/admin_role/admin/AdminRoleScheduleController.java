package com.tave.controller.admin_role.admin;


import com.tave.config.spring_security.auth.PrincipalDetails;
import com.tave.dto.admin.ScheduleDto;
import com.tave.service.admin.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/schedule")
public class AdminRoleScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/createSchedule")
    public ResponseEntity<?> createSchedule(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody ScheduleDto.SchedulePostDto schedulePostDto) {
        ScheduleDto.ScheduleResponseDto createdSchedule = scheduleService.createSchedule(principalDetails.getUser().getId(), schedulePostDto);
        return ResponseEntity.ok().body(createdSchedule);
    }

    @GetMapping("/getSchedule")
    public ResponseEntity<?> getSchedule(@RequestParam Long scheduleId) {
        ScheduleDto.ScheduleResponseDto schedule = scheduleService.getSchedule(scheduleId);
        return ResponseEntity.ok().body(schedule);
    }

    @PatchMapping("/modifySchedule")
    public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDto.SchedulePatchDto schedulePatchDto) {
        ScheduleDto.ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(schedulePatchDto);
        return ResponseEntity.ok().body(updatedSchedule);
    }

    @DeleteMapping("/deleteSchedule")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().body("삭제된 일정 ID: " + scheduleId);
    }

    @PatchMapping("/addAttendanceMember")
    public ResponseEntity<?> addAttendanceMember(@RequestParam Long scheduleId, @RequestParam Long memberId) {
        scheduleService.addAttendanceMemberId(scheduleId, memberId);
        return ResponseEntity.ok().body("스케줄 ID " + scheduleId + "에 멤버 ID " + memberId + "가 추가되었습니다.");
    }

    @GetMapping("/getAllSchedule")
    public ResponseEntity<List<ScheduleDto.ScheduleResponseDto>> getAllSchedule() {
        List<ScheduleDto.ScheduleResponseDto> schedules = scheduleService.getAllSchedule();
        return ResponseEntity.ok().body(schedules);
    }
}
