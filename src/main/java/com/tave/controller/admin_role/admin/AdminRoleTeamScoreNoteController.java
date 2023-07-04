package com.tave.controller.admin_role.admin;

import com.tave.dto.admin.TeamScoreNoteDto;
import com.tave.service.admin.TeamScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/teamScoreNote")
public class AdminRoleTeamScoreNoteController {

    private final TeamScoreNoteService teamScoreNoteService;

    @PostMapping("/createTeamScoreNote")
    public ResponseEntity<?> createTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto) {
        TeamScoreNoteDto.TeamScoreNoteResponseDto createdNote = teamScoreNoteService.createTeamScoreNote(teamScoreNotePostDto);
        return ResponseEntity.ok().body(createdNote);
    }

    @GetMapping("/getTeamScoreNote")
    public ResponseEntity<?> getTeamScoreNote(@RequestParam Long teamScoreNoteId) {
        TeamScoreNoteDto.TeamScoreNoteResponseDto teamScoreNote = teamScoreNoteService.getTeamScoreNote(teamScoreNoteId);
        return ResponseEntity.ok().body(teamScoreNote);
    }

    @PatchMapping("/modifyTeamScoreNote")
    public ResponseEntity<?> updateTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto) {
        TeamScoreNoteDto.TeamScoreNoteResponseDto updatedNote = teamScoreNoteService.updateTeamScoreNote(teamScoreNotePatchDto);
        return ResponseEntity.ok().body(updatedNote);
    }

    @DeleteMapping("/deleteTeamScoreNote")
    public ResponseEntity<?> deleteTeamScoreNote(@RequestParam Long teamScoreNoteId) {
        teamScoreNoteService.deleteTeamScoreNote(teamScoreNoteId);
        return ResponseEntity.ok().body("삭제된 팀 점수 노트 ID: " + teamScoreNoteId);
    }
}