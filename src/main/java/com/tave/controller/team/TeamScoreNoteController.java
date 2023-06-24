package com.tave.controller.team;

import com.tave.dto.team.TeamScoreNoteDto;
import com.tave.service.team.TeamScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("teamScoreNote")
public class TeamScoreNoteController {

    private final TeamScoreNoteService teamScoreNoteService;

    @PostMapping("/createTeamScoreNote")
    public ResponseEntity<?> createTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto){
        return ResponseEntity.ok().body(teamScoreNoteService.createTeamScoreNote(teamScoreNotePostDto));
    }

    @GetMapping("/getTeamScoreNote")
    public ResponseEntity<?> getTeamScoreNote(@RequestParam long teamScoreNoteId){
        return ResponseEntity.ok().body(teamScoreNoteService.getTeamScoreNote(teamScoreNoteId));
    }

    @PatchMapping("/modifyTeamScoreNote")
    public ResponseEntity<?> updateTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto){
        return ResponseEntity.ok().body(teamScoreNoteService.updateTeamScoreNote(teamScoreNotePatchDto));
    }

    @DeleteMapping("/deleteTeamScoreNote")
    public ResponseEntity<?> deleteTeamScoreNote(@RequestParam long teamScoreNoteId){
        teamScoreNoteService.deleteTeamScoreNote(teamScoreNoteId);
        return ResponseEntity.ok().body("deleted TeamScoreNoteId : " + teamScoreNoteId);
    }
}