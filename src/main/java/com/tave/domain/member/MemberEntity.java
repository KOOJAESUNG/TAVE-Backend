package com.tave.domain.member;

import com.tave.constant.TechField;
import com.tave.domain.team.TeamEntity;
import jakarta.persistence.*;
import lombok.Getter;
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

    @Lob
    private String picture; //프로필사진

    private Integer rad; //기수

    //추가
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private TechField techField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    private String university;

}
