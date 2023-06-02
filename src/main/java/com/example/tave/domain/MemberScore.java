package com.example.tave.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberScore {

    @Id
    @Column(name = "memberscore_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer totalScore;

    @OneToMany(mappedBy = "memberScore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberScoreNote> notes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
