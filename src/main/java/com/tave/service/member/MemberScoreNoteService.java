package com.tave.service.member;

import com.tave.dto.member.MemberScoreNoteDto;
import com.tave.repository.member.MemberScoreNoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberScoreNoteService {

    private final MemberScoreNoteRepository memberScoreNoteRepository;
    @Transactional
    public void createMemberScoreNote(MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto) {
        //dto->entity

        //save

        //entity->dto 후 return
    }

    public void getMemberScoreNote(Long memberScoreNoteId) {

    }

    @Transactional
    public void updateMemberScoreNote(MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteMemberScoreNote(Long memberScoreNoteId) {
        memberScoreNoteRepository.deleteById(memberScoreNoteId);
        log.info("Entity Id: {} is deleted", memberScoreNoteId);
    }
}
