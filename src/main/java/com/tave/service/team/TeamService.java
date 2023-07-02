package com.tave.service.team;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.team.TeamDto;
import com.tave.mapper.team.TeamMapper;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.team.TeamRepository;
import com.tave.repository.admin.TeamScoreNoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;
    private final AdminRepository adminRepository;
    private final TeamScoreNoteRepository teamScoreNoteRepository;

    private final TeamMapper teamMapper;

    @Transactional
    public TeamDto.TeamResponseDto createTeam(TeamDto.TeamPostDto teamPostDto) {
        AdminEntity adminEntity = null;
        if(teamPostDto.getAdminId()!=null)
            adminEntity = adminRepository.findById(teamPostDto.getAdminId()).orElseThrow(EntityNotFoundException::new);
        return teamMapper.toResponseDto(teamRepository.save(teamMapper.toEntity(teamPostDto, adminEntity)));
    }

    public TeamDto.TeamResponseDto getTeam(Long teamId) {
        return teamMapper.toResponseDto(teamRepository.findById(teamId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public TeamDto.TeamResponseDto updateTeam(TeamDto.TeamPatchDto teamPatchDto) {
        TeamEntity teamEntity = teamRepository.findById(teamPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        AdminEntity adminEntity = null;
        if(teamPatchDto.getAdminId()!=null)
            adminEntity = adminRepository.findById(teamPatchDto.getAdminId()).orElseThrow(EntityNotFoundException::new);
        //update
        teamMapper.updateFromPatchDto(teamPatchDto, adminEntity, teamEntity);
        //entity->dto 후 return
        return teamMapper.toResponseDto(teamRepository.findById(teamPatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
        log.info("TeamEntity Id: {} is deleted", teamId);
    }

    @Transactional
    public Integer getTeamScore(Long teamId) {
        if (!teamRepository.existsById(teamId))
            throw new EntityNotFoundException("TeamId: " + teamId + " not exists!!");
        return teamScoreNoteRepository.getTeamScoreByTeamId(teamId).orElse(0);
    }
}
