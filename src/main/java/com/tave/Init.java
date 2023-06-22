package com.tave;


import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import com.tave.domain.member.MemberEntity;
import com.tave.repository.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final MemberRepository memberRepository;
    @PostConstruct
    @Transactional
    public void memberInit() {
        MemberEntity build = MemberEntity.builder()
                .memberType(MemberType.YB)
                .email("test@test.com")
                .rad(11)
                .name("test")
                .introduce("testtesttest")
                .password("test")
                .phoneNumber("01011111111")
                .techField(TechField.BACKEND)
                .university("testuniv")
                .build();

        memberRepository.save(build);
    }


}
