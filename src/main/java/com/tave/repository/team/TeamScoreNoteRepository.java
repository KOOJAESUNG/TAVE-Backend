package com.tave.repository.team;

import com.tave.domain.team.TeamScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamScoreNoteRepository extends JpaRepository<TeamScoreNoteEntity,Long> {
}
