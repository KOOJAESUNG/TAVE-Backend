package com.example.tave.repository.team;

import com.example.tave.domain.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity,Long> {
}
