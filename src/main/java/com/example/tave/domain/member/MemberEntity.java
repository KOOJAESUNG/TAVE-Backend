package com.example.tave.domain.member;

import com.example.tave.domain.team.TeamEntity;
import jakarta.persistence.*;


@Entity
public class MemberEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;
    private String name;

    private String picture; //프로필사진

    private String email;

    @Lob
    private String introduce;

    private Integer rad; //기수

    private String university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;


    @Enumerated(EnumType.STRING)
    private TechField techField;

}
