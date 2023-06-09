package com.tave.service.team;

import com.tave.dto.team.TeamDto;
import com.tave.repository.team.TeamRepository;
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

    @Transactional
    public void createTeam(TeamDto.TeamPostDto teamPostDto) {
        //dto->entity

        //save

        //entity->dto 후 return
    }

    public void getTeam(Long teamId) {

    }

    @Transactional
    public void updateTeam() {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
        log.info("Entity Id: {} is deleted",teamId);
    }
}
