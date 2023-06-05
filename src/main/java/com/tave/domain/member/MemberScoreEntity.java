package com.tave.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class MemberScoreEntity {

    @Id
    @Column(name = "memberscore_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer totalScore;

    @OneToMany(mappedBy = "memberScore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberScoreNoteEntity> notes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
