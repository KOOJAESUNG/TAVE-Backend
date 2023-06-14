package com.tave.controller.team;

import com.tave.dto.team.TeamScoreNoteDto;
import com.tave.service.team.TeamScoreNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("teamScoreNote")
public class TeamScoreNoteController {

    @Autowired
    TeamScoreNoteService teamScoreNoteService;

    @PostMapping("/createteamscorenote")
    public ResponseEntity<?> createTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto){
        return ResponseEntity.ok().body(teamScoreNoteService.createTeamScoreNote(teamScoreNotePostDto));
    }

    @GetMapping("/getteamscorenote")
    public ResponseEntity<?> getTeamScoreNote(@RequestParam long teamScoreNoteId){
        return ResponseEntity.ok().body(teamScoreNoteService.getTeamScoreNote(teamScoreNoteId));
    }

    @PatchMapping("/modifyteamscorenote")
    public ResponseEntity<?> updateTeamScoreNote(@RequestBody TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto){
        return ResponseEntity.ok().body(teamScoreNoteService.updateTeamScoreNote(teamScoreNotePatchDto));
    }

    @DeleteMapping("/deletememberscorenote")
    public ResponseEntity<?> deleteTeamScoreNote(@RequestParam long teamScoreNoteId){
        teamScoreNoteService.deleteTeamScoreNote(teamScoreNoteId);
        return ResponseEntity.ok().body("deleted TeamScoreNoteId : " + teamScoreNoteId);
    }
}