package com.tave.repository.member;

import com.tave.domain.member.MemberScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberScoreNoteRepository extends JpaRepository<MemberScoreNoteEntity,Long> {
}
