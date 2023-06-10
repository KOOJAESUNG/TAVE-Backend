package com.tave.service.member;

import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import com.tave.mapper.member.MemberMapper;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.team.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final MemberMapper memberMapper;

    //회원가입을 안하기 때문에 create는 없음

    public MemberDto.MemberResponseDto getMember(Long memberId) {
        //entity->dto 후 return
        return memberMapper.toResponseDto(memberRepository.findById(memberId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public MemberDto.MemberResponseDto updateMember(MemberDto.MemberPatchDto memberPatchDto) {
        MemberEntity memberEntity = memberRepository.findById(memberPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        TeamEntity teamEntity = teamRepository.findById(memberPatchDto.getTeamId()).orElseThrow(EntityNotFoundException::new);
        //update
        memberEntity.updateFromPatchDto(memberPatchDto,teamEntity);
        //entity->dto 후 return
        return memberMapper.toResponseDto(memberRepository.findById(memberPatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
        log.info("MemberEntity Id: {} is deleted",memberId);
    }
}
