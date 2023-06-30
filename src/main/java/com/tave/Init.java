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
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
    }

    @PostConstruct
    @Transactional
    public void adminInit() {
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
    }


}
