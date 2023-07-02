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
    public ResponseEntity<?> createTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto){
        return ResponseEntity.ok().body(teamScoreNoteService.createTeamScoreNote(teamScoreNotePostDto));
    }

    @GetMapping("/getTeamScoreNote")
    public ResponseEntity<?> getTeamScoreNote(@RequestParam Long teamScoreNoteId){
        return ResponseEntity.ok().body(teamScoreNoteService.getTeamScoreNote(teamScoreNoteId));
    }

    @PatchMapping("/modifyTeamScoreNote")
    public ResponseEntity<?> updateTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto){
        return ResponseEntity.ok().body(teamScoreNoteService.updateTeamScoreNote(teamScoreNotePatchDto));
    }

    @DeleteMapping("/deleteTeamScoreNote")
    public ResponseEntity<?> deleteTeamScoreNote(@RequestParam Long teamScoreNoteId){
        teamScoreNoteService.deleteTeamScoreNote(teamScoreNoteId);
        return ResponseEntity.ok().body("deleted TeamScoreNoteId : " + teamScoreNoteId);
    }
}