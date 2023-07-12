package com.tave.service.admin;

import com.tave.domain.admin.NoticeEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.domain.admin.TeamScoreNoteEntity;
import com.tave.dto.admin.NoticeDto;
import com.tave.dto.admin.TeamScoreNoteDto;
import com.tave.exception.BusinessLogicException;
import com.tave.exception.ExceptionCode;
import com.tave.mapper.admin.TeamScoreNoteMapper;
import com.tave.repository.team.TeamRepository;
import com.tave.repository.admin.TeamScoreNoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        TeamEntity teamEntity = teamRepository.findById(teamScoreNotePostDto.getTeamId())
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.CREATE_FAIL_TEAMSCORENOTE));
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.save(teamScoreNoteMapper.toEntity(teamScoreNotePostDto, teamEntity)));
    }

    public TeamScoreNoteDto.TeamScoreNoteResponseDto getTeamScoreNote(Long teamScoreNoteId) {
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.findById(teamScoreNoteId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.TEAMSCORENOTE_IS_NOT_EXIST)));
    }

    @Transactional
    public TeamScoreNoteDto.TeamScoreNoteResponseDto updateTeamScoreNote(TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto) {
        TeamScoreNoteEntity teamScoreNoteEntity = teamScoreNoteRepository.findById(teamScoreNotePatchDto.getId())
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.TEAMSCORENOTE_IS_NOT_EXIST));
        TeamEntity teamEntity = teamRepository.findById(teamScoreNotePatchDto.getTeamId())
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.TEAM_NOT_FOUND));
        //update
//        teamScoreNoteEntity.updateFromPatchDto(teamScoreNotePatchDto, teamEntity);
        teamScoreNoteMapper.updateFromPatchDto(teamScoreNotePatchDto,teamEntity,teamScoreNoteEntity);
        //entity->dto 후 return
        return teamScoreNoteMapper.toResponseDto(teamScoreNoteRepository.findById(teamScoreNotePatchDto.getId())
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.UPDATE_FAIL_TEAMSCORENOTE)));
    }

    @Transactional
    public void deleteTeamScoreNote(Long teamScoreNoteId) {
        teamScoreNoteRepository.deleteById(teamScoreNoteId);
        log.info("TeamScoreNoteEntity Id: {} is deleted",teamScoreNoteId);
    }

    @Transactional
    public List<TeamScoreNoteDto.TeamScoreNoteResponseDto> getAllTeamScoreNote(){

        List<TeamScoreNoteEntity> teamScoreNoteEntities = teamScoreNoteRepository.getAllTeamScoreNote();
        List<TeamScoreNoteDto.TeamScoreNoteResponseDto> teamScoreNoteResponseDtos = new ArrayList<>();

        for (TeamScoreNoteEntity teamScoreNoteEntity : teamScoreNoteEntities){
            TeamScoreNoteDto.TeamScoreNoteResponseDto teamScoreNoteResponseDto = teamScoreNoteMapper.toResponseDto(teamScoreNoteEntity);
            teamScoreNoteResponseDtos.add(teamScoreNoteResponseDto);
        }

        return teamScoreNoteResponseDtos;
    }
}
