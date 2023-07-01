package com.tave.controller.team;

import com.tave.dto.team.TeamDto;
import com.tave.repository.team.TeamScoreNoteRepository;
import com.tave.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto.TeamPostDto teamPostDto) {
        return ResponseEntity.ok().body(teamService.createTeam(teamPostDto));
    }

    @GetMapping("/getTeam")
    public ResponseEntity<?> getTeam(@RequestParam long teamId) {
        return ResponseEntity.ok().body(teamService.getTeam(teamId));
    }

    @PatchMapping("/modifyTeam")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto.TeamPatchDto teamPatchDto) {
        return ResponseEntity.ok().body(teamService.updateTeam(teamPatchDto));
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<?> deleteTeam(@RequestParam long teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().body("deleted TeamId : " + teamId);
    }

    @GetMapping("/getTeamScore")
    public ResponseEntity<?> getTeamScore(Long teamId) {
        return ResponseEntity.ok().body(teamService.getTeamScore(teamId));
    }
}
