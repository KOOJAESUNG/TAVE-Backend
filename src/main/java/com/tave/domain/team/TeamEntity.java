package com.tave.domain.team;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    private Integer teamScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<MemberEntity> members = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<TeamScoreNoteEntity> notes = new ArrayList<>();



}
