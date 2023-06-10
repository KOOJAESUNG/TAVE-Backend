package com.tave.repository.team;

import com.tave.domain.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity,Long> {

    @Query("select t from TeamEntity t where t.id in :teamIds")
    List<TeamEntity> findByIdIn(@Param("teamIds") List<Long> teamIds);
}
