package com.tave.service.member;

import com.tave.dto.member.MemberDto;
import com.tave.repository.member.MemberRepository;
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

    //회원가입을 안하기 때문에 create는 없음

    public void getMember(Long memberId) {
        //entity->dto 후 return

    }

    @Transactional
    public void updateMember(MemberDto.MemberPatchDto memberPatchDto) {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
        log.info("Entity Id: {} is deleted",memberId);
    }
}
