package com.tave.service.member;

import com.tave.domain.member.MemberEntity;
import com.tave.domain.member.MemberScoreNoteEntity;
import com.tave.dto.member.MemberScoreNoteDto;
import com.tave.mapper.member.MemberScoreNoteMapper;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.member.MemberScoreNoteRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final MemberRepository memberRepository;
    private final MemberScoreNoteMapper memberScoreNoteMapper;
    @Transactional
    public MemberScoreNoteDto.MemberScoreNoteResponseDto createMemberScoreNote(MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto) {
        MemberEntity memberEntity = memberRepository.findById(memberScoreNotePostDto.getMemberId()).orElseThrow(EntityNotFoundException::new);
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.save(memberScoreNoteMapper.toEntity(memberScoreNotePostDto,memberEntity)));
    }

    public MemberScoreNoteDto.MemberScoreNoteResponseDto getMemberScoreNote(Long memberScoreNoteId) {
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.findById(memberScoreNoteId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public MemberScoreNoteDto.MemberScoreNoteResponseDto updateMemberScoreNote(MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        MemberScoreNoteEntity memberScoreNoteEntity = memberScoreNoteRepository.findById(memberScoreNotePatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        //update
//        memberScoreNoteEntity.updateFromPatchDto(memberScoreNotePatchDto);
        memberScoreNoteMapper.updateFromPatchDto(memberScoreNotePatchDto,memberScoreNoteEntity);
        //entity->dto 후 return
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.findById(memberScoreNotePatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteMemberScoreNote(Long memberScoreNoteId) {
        memberScoreNoteRepository.deleteById(memberScoreNoteId);
        log.info("MemberScoreNoteEntity Id: {} is deleted", memberScoreNoteId);
    }
}
