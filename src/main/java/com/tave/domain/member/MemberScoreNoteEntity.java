package com.tave.domain.member;


import jakarta.persistence.*;

@Entity
public class MemberScoreNoteEntity {
    @Id
    @Column(name = "memberscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer score;

    private String type;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberscore_id")
    private MemberScoreEntity memberScore;
}
