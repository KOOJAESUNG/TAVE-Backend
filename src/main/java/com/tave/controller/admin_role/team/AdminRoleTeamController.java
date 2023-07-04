package com.tave.controller.admin_role.team;

import com.tave.dto.team.TeamDto;
import com.tave.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/team")
public class AdminRoleTeamController {

    private final TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto.TeamPostDto teamPostDto) {
        TeamDto.TeamResponseDto createdTeam = teamService.createTeam(teamPostDto);
        return ResponseEntity.ok().body(createdTeam);
    }

    @GetMapping("/getTeam")
    public ResponseEntity<?> getTeam(@RequestParam Long teamId) {
        TeamDto.TeamResponseDto team = teamService.getTeam(teamId);
        return ResponseEntity.ok().body(team);
    }

    @PatchMapping("/modifyTeam")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto.TeamPatchDto teamPatchDto) {
        TeamDto.TeamResponseDto updatedTeam = teamService.updateTeam(teamPatchDto);
        return ResponseEntity.ok().body(updatedTeam);
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<?> deleteTeam(@RequestParam Long teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().body("삭제된 팀 ID: " + teamId);
    }

    @GetMapping("/getTeamScore")
    public ResponseEntity<?> getTeamScore(@RequestParam Long teamId) {
        return ResponseEntity.ok().body(teamService.getTeamScore(teamId));
    }

}
