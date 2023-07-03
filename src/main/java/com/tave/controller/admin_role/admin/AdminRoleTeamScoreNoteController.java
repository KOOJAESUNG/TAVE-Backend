package com.tave.controller.admin_role.admin;

import com.tave.dto.admin.TeamScoreNoteDto;
import com.tave.service.admin.TeamScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/teamScoreNote")
public class AdminRoleTeamScoreNoteController {

    private final TeamScoreNoteService teamScoreNoteService;

    @PostMapping("/createTeamScoreNote")
    public ResponseEntity<?> createTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto) {
        try {
            TeamScoreNoteDto.TeamScoreNoteResponseDto createdNote = teamScoreNoteService.createTeamScoreNote(teamScoreNotePostDto);
            return ResponseEntity.ok().body(createdNote);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the team score note.");
        }
    }

    @GetMapping("/getTeamScoreNote")
    public ResponseEntity<?> getTeamScoreNote(@RequestParam Long teamScoreNoteId) {
        try {
            TeamScoreNoteDto.TeamScoreNoteResponseDto teamScoreNote = teamScoreNoteService.getTeamScoreNote(teamScoreNoteId);
            return ResponseEntity.ok().body(teamScoreNote);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the team score note.");
        }
    }
    @PatchMapping("/modifyTeamScoreNote")
    public ResponseEntity<?> updateTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto) {
        try {
            TeamScoreNoteDto.TeamScoreNoteResponseDto updatedNote = teamScoreNoteService.updateTeamScoreNote(teamScoreNotePatchDto);
            return ResponseEntity.ok().body(updatedNote);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the team score note.");
        }
    }

    @DeleteMapping("/deleteTeamScoreNote")
    public ResponseEntity<?> deleteTeamScoreNote(@RequestParam Long teamScoreNoteId) {
        try {
            teamScoreNoteService.deleteTeamScoreNote(teamScoreNoteId);
            return ResponseEntity.ok().body("Deleted TeamScoreNoteId: " + teamScoreNoteId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the team score note.");
        }
    }
}