package com.tave.repository.admin;

import com.tave.domain.admin.ScheduleEntity;
import com.tave.domain.admin.TeamScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamScoreNoteRepository extends JpaRepository<TeamScoreNoteEntity,Long> {

    @Query("select sum(t.score) from TeamScoreNoteEntity t where t.team.id = :teamId")
    Optional<Integer> getTeamScoreByTeamId(@Param("teamId") Long teamId);

    @Query("SELECT tsn FROM TeamScoreNoteEntity tsn")
    List<TeamScoreNoteEntity> getAllTeamScoreNote();

}
