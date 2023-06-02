package com.example.tave.repository.team;

import com.example.tave.domain.team.TeamScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamScoreNoteRepository extends JpaRepository<TeamScoreNoteEntity,Long> {
}
