package com.tave.repository.member;

import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    MemberEntity findByUsername(String username);

    @Query("SELECT m FROM MemberEntity m")
    List<MemberEntity> getAllMember();
}
