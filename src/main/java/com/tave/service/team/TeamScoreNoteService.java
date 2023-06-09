package com.tave.service.team;

import com.tave.dto.team.TeamScoreNoteDto;
import com.tave.repository.team.TeamScoreNoteRepository;
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

    @Transactional
    public void createTeamScoreNote(TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto) {
        //dto->entity

        //save

        //entity->dto 후 return
    }

    public void getTeamScoreNote(Long teamScoreNoteId) {

    }

    @Transactional
    public void updateTeamScoreNote(TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto) {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteTeamScoreNote(Long teamScoreNoteId) {
        teamScoreNoteRepository.deleteById(teamScoreNoteId);
        log.info("Entity Id: {} is deleted",teamScoreNoteId);
    }
}
