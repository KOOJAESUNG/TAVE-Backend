package com.tave.controller.team;

import com.tave.dto.team.TeamDto;
import com.tave.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/getteam")
    public ResponseEntity<?> getTeam(@RequestParam long teamId){
        return ResponseEntity.ok().body(teamService.getTeam(teamId));
    }

    @PatchMapping("/modifyteam")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto.TeamPatchDto teamPatchDto){
        return ResponseEntity.ok().body(teamService.updateTeam(teamPatchDto));
    }

    @DeleteMapping("/deleteteam")
    public ResponseEntity<?> deleteTeam(@RequestParam long teamId){
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().body("deleted TeamId : " + teamId);
    }
}
