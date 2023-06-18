package com.tave.service.team;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.team.TeamDto;
import com.tave.mapper.team.TeamMapper;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.team.TeamRepository;
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

    private final TeamMapper teamMapper;

    @Transactional
    public TeamDto.TeamResponseDto createTeam(TeamDto.TeamPostDto teamPostDto) {
        AdminEntity byEmail = adminRepository.findById(teamPostDto.getAdminId()).orElseThrow(EntityNotFoundException::new);
        return teamMapper.toResponseDto(teamRepository.save(teamMapper.toEntity(teamPostDto, byEmail)));
    }

    public TeamDto.TeamResponseDto getTeam(Long teamId) {
        return teamMapper.toResponseDto(teamRepository.findById(teamId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public TeamDto.TeamResponseDto updateTeam(TeamDto.TeamPatchDto teamPatchDto) {
        TeamEntity teamEntity = teamRepository.findById(teamPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        AdminEntity byEmail = adminRepository.findById(teamPatchDto.getAdminId()).orElseThrow(EntityNotFoundException::new);
        //update
//        teamEntity.updateFromPatchDto(teamPatchDto,byEmail);
        teamMapper.updateFromPatchDto(teamPatchDto,byEmail,teamEntity);
        //entity->dto 후 return
        return teamMapper.toResponseDto(teamRepository.findById(teamPatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
        log.info("TeamEntity Id: {} is deleted",teamId);
    }
}
