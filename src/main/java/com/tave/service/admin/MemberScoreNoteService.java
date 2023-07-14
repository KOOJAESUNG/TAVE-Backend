package com.tave.service.admin;

import com.tave.domain.member.MemberEntity;
import com.tave.domain.admin.MemberScoreNoteEntity;
import com.tave.dto.admin.MemberScoreNoteDto;
import com.tave.exception.BusinessLogicException;
import com.tave.exception.ExceptionCode;
import com.tave.mapper.admin.MemberScoreNoteMapper;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.admin.MemberScoreNoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        MemberEntity memberEntity = memberRepository.findById(memberScoreNotePostDto.getMemberId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.CREATE_FAIL_MEMBERSCORENOTE));
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.save(memberScoreNoteMapper.toEntity(memberScoreNotePostDto, memberEntity)));
    }

    public MemberScoreNoteDto.MemberScoreNoteResponseDto getMemberScoreNote(Long memberScoreNoteId) {
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.findById(memberScoreNoteId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBERSCORENOTE_IS_NOT_EXIST)));
    }

    @Transactional
    public MemberScoreNoteDto.MemberScoreNoteResponseDto updateMemberScoreNote(MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        MemberScoreNoteEntity memberScoreNoteEntity = memberScoreNoteRepository.findById(memberScoreNotePatchDto.getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBERSCORENOTE_IS_NOT_EXIST));
        //update
//        memberScoreNoteEntity.updateFromPatchDto(memberScoreNotePatchDto);
        memberScoreNoteMapper.updateFromPatchDto(memberScoreNotePatchDto, memberScoreNoteEntity);
        //entity->dto 후 return
        return memberScoreNoteMapper.toResponseDto(memberScoreNoteRepository.findById(memberScoreNotePatchDto.getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.UPDATE_FAIL_ADMIN)));
    }

    @Transactional
    public void deleteMemberScoreNote(Long memberScoreNoteId) {
        memberScoreNoteRepository.deleteById(memberScoreNoteId);
        log.info("MemberScoreNoteEntity Id: {} is deleted", memberScoreNoteId);
    }

    public List<MemberScoreNoteDto.MemberScoreNoteResponseDto> getMembersAllMemberScoreNote(Long memberId) {
        List<MemberScoreNoteDto.MemberScoreNoteResponseDto> list = new ArrayList<>();
        memberScoreNoteRepository.findMemberScoreNoteEntitiesByMemberId(memberId).
                orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBERSCORENOTE_IS_NOT_EXIST)).
                forEach(m ->
                    list.add(memberScoreNoteMapper.toResponseDto(m))
                );
        return list;
    }

    @Transactional
    public List<MemberScoreNoteDto.MemberScoreNoteResponseDto> getAllMemberScoreNote(){

        List<MemberScoreNoteEntity> memberScoreNoteEntities = memberScoreNoteRepository.getAllMemberScoreNote();
        List<MemberScoreNoteDto.MemberScoreNoteResponseDto> memberScoreNoteResponseDtos = new ArrayList<>();

        for (MemberScoreNoteEntity memberScoreNoteEntity : memberScoreNoteEntities){
            MemberScoreNoteDto.MemberScoreNoteResponseDto memberScoreNoteResponseDto = memberScoreNoteMapper.toResponseDto(memberScoreNoteEntity);
            memberScoreNoteResponseDtos.add(memberScoreNoteResponseDto);
        }

        return memberScoreNoteResponseDtos;
    }
}
