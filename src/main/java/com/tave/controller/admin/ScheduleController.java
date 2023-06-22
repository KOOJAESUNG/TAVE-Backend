package com.tave.controller.admin;


import com.tave.dto.admin.ScheduleDto;
import com.tave.service.admin.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/createschedule")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleDto.SchedulePostDto schedulePostDto){
        return ResponseEntity.ok().body(scheduleService.createSchedule(schedulePostDto));
    }

    @GetMapping("/getschedule")
    public ResponseEntity<?> getSchedule(@RequestParam long scheduleId){
        return ResponseEntity.ok().body(scheduleService.getSchedule(scheduleId));
    }

    @PatchMapping("/modifyschedule")
    public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDto.SchedulePatchDto schedulePatchDto){
        return ResponseEntity.ok().body(scheduleService.updateSchedule(schedulePatchDto));
    }

    @DeleteMapping("/deleteschedule")
    public ResponseEntity<?> deleteSchedule(@RequestParam long scheduleId){
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().body("deleted ScheduleId : " + scheduleId);
    }
}
