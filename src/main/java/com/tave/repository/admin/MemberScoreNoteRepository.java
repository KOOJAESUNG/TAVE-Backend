package com.tave.repository.admin;

import com.tave.domain.admin.MemberScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberScoreNoteRepository extends JpaRepository<MemberScoreNoteEntity,Long> {

    @Query("select sum(m.score) from MemberScoreNoteEntity m where m.member.id = :memberId")
    Optional<Integer> getMemberScoreByMemberId(@Param("memberId") Long memberId);

    Optional<List<MemberScoreNoteEntity>> findMemberScoreNoteEntitiesByMemberId(Long memberId);

    @Query("SELECT msn FROM MemberScoreNoteEntity msn")
    List<MemberScoreNoteEntity> getAllMemberScoreNote();
}
