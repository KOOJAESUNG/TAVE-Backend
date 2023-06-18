package com.tave.service.team;

import com.tave.domain.team.TeamEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import com.tave.dto.team.TeamScoreNoteDto;
import com.tave.mapper.team.TeamScoreNoteMapper;
import com.tave.repository.team.TeamRepository;
import com.tave.repository.team.TeamScoreNoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TeamScoreNoteService {

    private final TeamScoreNoteRepository teamScoreNoteRepository;
    private final TeamRepository teamRepository;
    private final TeamScoreNoteMapper teamScoreNoteMapper;

    @Transactional
    public TeamScoreNoteDto.TeamScoreNoteResponseDto createTeamScoreNote(TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto) {
        TeamEntity teamEntity = teamRepository.findById(teamScoreNotePostDto.getTeamId()).orElseThrow(EntityNotFoundException::new);
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.save(teamScoreNoteMapper.toEntity(teamScoreNotePostDto, teamEntity)));
    }

    public TeamScoreNoteDto.TeamScoreNoteResponseDto getTeamScoreNote(Long teamScoreNoteId) {
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.findById(teamScoreNoteId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public TeamScoreNoteDto.TeamScoreNoteResponseDto updateTeamScoreNote(TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto) {
        TeamScoreNoteEntity teamScoreNoteEntity = teamScoreNoteRepository.findById(teamScoreNotePatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        TeamEntity teamEntity = teamRepository.findById(teamScoreNotePatchDto.getTeamId()).orElseThrow(EntityNotFoundException::new);
        //update
//        teamScoreNoteEntity.updateFromPatchDto(teamScoreNotePatchDto, teamEntity);
        teamScoreNoteMapper.updateFromPatchDto(teamScoreNotePatchDto,teamEntity,teamScoreNoteEntity);
        //entity->dto 후 return
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.findById(teamScoreNotePatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteTeamScoreNote(Long teamScoreNoteId) {
        teamScoreNoteRepository.deleteById(teamScoreNoteId);
        log.info("TeamScoreNoteEntity Id: {} is deleted",teamScoreNoteId);
    }
}
