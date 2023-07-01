package com.tave.repository.team;

import com.tave.domain.team.TeamScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamScoreNoteRepository extends JpaRepository<TeamScoreNoteEntity,Long> {

    @Query("select sum(t.score) from TeamScoreNoteEntity t where t.team.id = :teamId")
    Optional<Integer> getTeamScoreByTeamId(@Param("teamId") Long teamId);
}
