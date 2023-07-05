package com.tave.service.member;

import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import com.tave.exception.BusinessLogicException;
import com.tave.exception.ExceptionCode;
import com.tave.mapper.member.MemberMapper;
import com.tave.repository.admin.MemberScoreNoteRepository;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.team.TeamRepository;
import com.tave.api.aws.S3Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberScoreNoteRepository memberScoreNoteRepository;
    private final TeamRepository teamRepository;
    private final MemberMapper memberMapper;
    private final S3Service s3Service;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Transactional
//    public MemberDto.MemberResponseDto createMember(MemberDto.MemberPostDto memberPostDto) {
//        return memberMapper.toResponseDto(memberRepository.save(memberMapper.toEntity(memberPostDto)));
//    }
    public MemberDto.MemberResponseDto getMember(Long memberId) {
        //entity->dto 후 return
        return memberMapper.toResponseDto(memberRepository.findById(memberId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)));
    }

    @Transactional
    public MemberDto.MemberResponseDto updateMember(Long memberId,MemberDto.MemberPatchDto memberPatchDto) {
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        TeamEntity teamEntity=null;
        if(memberPatchDto.getTeamId()!=null)
            teamEntity = teamRepository.findById(memberPatchDto.getTeamId())
                    .orElseThrow(()->new BusinessLogicException(ExceptionCode.TEAM_NOT_FOUND));
        //update
        if(memberPatchDto.getPassword()!=null) memberPatchDto.setPassword(bCryptPasswordEncoder.encode(memberPatchDto.getPassword()));
        memberMapper.updateFromPatchDto(memberPatchDto,teamEntity,memberEntity);
        //entity->dto 후 return
        return memberMapper.toResponseDto(memberRepository.findById(memberId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.UPDATE_FAIL_MEMBER)));
    }

    @Transactional
    public String updateMemberProfileImage(Long memberId, MultipartFile profileImage) {
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        s3Service.deleteFile(memberEntity.getProfileImage());
        memberMapper.updateProfileImage(s3Service.uploadFile(profileImage),memberEntity);

        return memberRepository.findById(memberId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.UPDATE_FAIL_MEMBERIMAGE)).getProfileImage();
    }
    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
        log.info("MemberEntity Id: {} is deleted",memberId);
    }

    public Integer getMemberScore(Long memberId) {
        if(!memberRepository.existsById(memberId))
            throw new EntityNotFoundException("MemberId: " + memberId + " not exists!!");
        return memberScoreNoteRepository.getMemberScoreByMemberId(memberId).orElse(0);
    }
}
