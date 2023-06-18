package com.tave.domain.member;

import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import com.tave.repository.member.MemberRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
public class MemberEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    @Lob
    private String introduce;

    private String name;

    private String password;

    private String picture; //프로필사진. URI가 들어갈 예정

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


    public void updateFromPatchDto(MemberDto.MemberPatchDto memberPatchDto,TeamEntity team) {
        if(memberPatchDto.getEmail() != null) this.email = memberPatchDto.getEmail();
        if(memberPatchDto.getIntroduce() != null) this.introduce = memberPatchDto.getIntroduce();
        if(memberPatchDto.getName() != null) this.name = memberPatchDto.getName();
        if(memberPatchDto.getPassword() != null) this.password = memberPatchDto.getPassword();
        if(memberPatchDto.getPicture() != null) this.picture = memberPatchDto.getPicture();
        if(memberPatchDto.getRad() != null) this.rad = memberPatchDto.getRad();
        if(memberPatchDto.getPhoneNumber() != null) this.phoneNumber = memberPatchDto.getPhoneNumber();
        if(memberPatchDto.getTechField() != null) this.techField = TechField.valueOf(memberPatchDto.getTechField());
        if(team != null) this.team = team;
        if(memberPatchDto.getUniversity() != null) this.university = memberPatchDto.getUniversity();
        if(memberPatchDto.getMemberType() != null) this.memberType = MemberType.valueOf(memberPatchDto.getMemberType());
    }

}
