package com.tave.controller.admin_role.admin;


import com.tave.dto.admin.ScheduleDto;
import com.tave.service.admin.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/schedule")
public class AdminRoleScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/createSchedule")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleDto.SchedulePostDto schedulePostDto) {
        return ResponseEntity.ok().body(scheduleService.createSchedule(schedulePostDto));
    }

    @GetMapping("/getSchedule")
    public ResponseEntity<?> getSchedule(@RequestParam Long scheduleId) {
        return ResponseEntity.ok().body(scheduleService.getSchedule(scheduleId));
    }

    @PatchMapping("/modifySchedule")
    public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDto.SchedulePatchDto schedulePatchDto) {
        return ResponseEntity.ok().body(scheduleService.updateSchedule(schedulePatchDto));
    }

    @DeleteMapping("/deleteSchedule")
    public ResponseEntity<?> deleteSchedule(@RequestParam Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().body("deleted ScheduleId : " + scheduleId);
    }

    @PatchMapping("/addAttendanceMember")
    public ResponseEntity<?> addAttendanceMember(@RequestParam Long scheduleId, @RequestParam Long memberId) {
        scheduleService.addAttendanceMemberId(scheduleId,memberId);
        return ResponseEntity.ok().body("Member Id: "+memberId+" is added in Schedule Id: "+scheduleId);
    }

    @GetMapping("/getAllSchedule")
    public ResponseEntity<List<ScheduleDto.ScheduleResponseDto>> getAllSchedule() {
        List<ScheduleDto.ScheduleResponseDto> schedules = scheduleService.getAllSchedule();
        return ResponseEntity.ok().body(schedules);
    }



}
