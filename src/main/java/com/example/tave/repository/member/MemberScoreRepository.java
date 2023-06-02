package com.example.tave.repository.member;

import com.example.tave.domain.member.MemberScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberScoreRepository extends JpaRepository<MemberScoreEntity,Long> {
}
