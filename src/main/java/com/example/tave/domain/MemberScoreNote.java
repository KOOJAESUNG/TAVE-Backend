package com.example.tave.domain;


import javax.persistence.*;

@Entity
public class MemberScoreNote {
    @Id
    @Column(name = "memberscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer score;

    private String type;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberscore_id")
    private MemberScore memberScore;
}
