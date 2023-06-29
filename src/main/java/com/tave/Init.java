package com.tave;


import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    @PostConstruct
    @Transactional
    public void memberInit() {
        memberRepository.save(MemberEntity.builder().build());
        memberRepository.save(MemberEntity.builder().build());
        memberRepository.save(MemberEntity.builder().build());
        memberRepository.save(MemberEntity.builder().build());
        memberRepository.save(MemberEntity.builder().build());
        memberRepository.save(MemberEntity.builder().build());
    }

    @PostConstruct
    @Transactional
    public void adminInit() {
        adminRepository.save(AdminEntity.builder().build());
        adminRepository.save(AdminEntity.builder().build());
        adminRepository.save(AdminEntity.builder().build());
        adminRepository.save(AdminEntity.builder().build());
        adminRepository.save(AdminEntity.builder().build());
        adminRepository.save(AdminEntity.builder().build());
    }


}
