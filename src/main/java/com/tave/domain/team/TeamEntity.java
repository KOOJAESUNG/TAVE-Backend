package com.tave.domain.team;

import com.tave.domain.TimeStamp;
import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.TeamScoreNoteEntity;
import com.tave.domain.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class TeamEntity extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @OneToMany(mappedBy = "team")
    private List<MemberEntity> members = new ArrayList<>();

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamScoreNoteEntity> notes = new ArrayList<>();


}
