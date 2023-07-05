package com.tave.controller.member_role.admin;


import com.tave.dto.admin.ScheduleDto;
import com.tave.service.admin.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("memberRole/schedule")
public class MemberRoleScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/getSchedule")
    public ResponseEntity<?> getSchedule(@RequestParam Long scheduleId) {
        return ResponseEntity.ok().body(scheduleService.getSchedule(scheduleId));
    }

    @GetMapping("/getAllSchedule")
    public ResponseEntity<List<ScheduleDto.ScheduleResponseDto>> getAllSchedule() {
        List<ScheduleDto.ScheduleResponseDto> schedules = scheduleService.getAllSchedule();
        return ResponseEntity.ok().body(schedules);
    }


}
