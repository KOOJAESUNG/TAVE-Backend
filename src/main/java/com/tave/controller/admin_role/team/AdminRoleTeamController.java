package com.tave.controller.admin_role.team;

import com.tave.dto.admin.TeamScoreNoteDto;
import com.tave.dto.team.TeamDto;
import com.tave.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("adminRole/team")
public class AdminRoleTeamController {

    private final TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto.TeamPostDto teamPostDto) {
        try {
            TeamDto.TeamResponseDto createdTeam = teamService.createTeam(teamPostDto);
            return ResponseEntity.ok().body(createdTeam);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the team.");
        }
    }
    @GetMapping("/getTeam")
    public ResponseEntity<?> getTeam(@RequestParam Long teamId) {
        try {
            TeamDto.TeamResponseDto team = teamService.getTeam(teamId);
            return ResponseEntity.ok().body(team);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the team.");
        }
    }
    @PatchMapping("/modifyTeam")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto.TeamPatchDto teamPatchDto) {
        try {
            TeamDto.TeamResponseDto updatedTeam = teamService.updateTeam(teamPatchDto);
            return ResponseEntity.ok().body(updatedTeam);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the team.");
        }
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<?> deleteTeam(@RequestParam Long teamId) {
        try {
            teamService.deleteTeam(teamId);
            return ResponseEntity.ok().body("Deleted TeamId: " + teamId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the team.");
        }
    }
    @GetMapping("/getTeamScore")
    public ResponseEntity<?> getTeamScore(@RequestParam Long teamId) {
        try {
            return ResponseEntity.ok().body(teamService.getTeamScore(teamId));
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the team score.");
        }
    }
}
