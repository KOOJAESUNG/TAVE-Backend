package com.tave.repository.admin;

import com.tave.domain.admin.MemberScoreNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberScoreNoteRepository extends JpaRepository<MemberScoreNoteEntity,Long> {
}
