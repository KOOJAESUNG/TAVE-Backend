package com.tave.domain.member;

import com.tave.constant.MemberType;
import com.tave.constant.Role;
import com.tave.constant.TechField;
import com.tave.domain.TimeStamp;
import com.tave.domain.UserEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import com.tave.repository.member.MemberRepository;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class MemberEntity extends TimeStamp implements UserEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private final Role role = Role.MEMBER;

    private String username; //회원 아이디

    private String email;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String introduce;

    private String name;

    private String password;

    private String profileImage;

    private Integer rad; //기수

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private TechField techField;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    private String university;

    private Boolean checkSms = false;   //false == 첫로그인 true == 이미 인증한사람

}
