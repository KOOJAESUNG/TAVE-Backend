package com.tave.controller.member_role.team;

import com.tave.dto.team.TeamDto;
import com.tave.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("memberRole/team")
public class MemberRoleTeamController {

    private final TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto.TeamPostDto teamPostDto) {
        try {
            // 팀 생성
            TeamDto.TeamResponseDto createdTeam = teamService.createTeam(teamPostDto);
            return ResponseEntity.ok().body(createdTeam);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/getTeam")
    public ResponseEntity<?> getTeam(@RequestParam Long teamId) {
        try {
            // 팀 조회
            TeamDto.TeamResponseDto team = teamService.getTeam(teamId);
            if (team != null) {
                return ResponseEntity.ok().body(team);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/modifyTeam")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto.TeamPatchDto teamPatchDto) {
        try {
            // 팀 업데이트
            TeamDto.TeamResponseDto updatedTeam = teamService.updateTeam(teamPatchDto);
            if (updatedTeam != null) {
                return ResponseEntity.ok().body(updatedTeam);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<?> deleteTeam(@RequestParam Long teamId) {
        try {
            // 팀 삭제
            teamService.deleteTeam(teamId);
            return ResponseEntity.ok().body("deleted TeamId : " + teamId);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getTeamScore")
    public ResponseEntity<?> getTeamScore(@RequestParam Long teamId) {
        try {
            // 팀 점수 조회
            return ResponseEntity.ok().body(teamService.getTeamScore(teamId));
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            // 예외 처리에 따른 클라이언트에게 알림을 전달하는 코드 추가
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
