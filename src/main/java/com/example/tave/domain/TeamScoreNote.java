package com.example.tave.domain;

import javax.persistence.*;

@Entity
public class TeamScoreNote {
    @Id
    @Column(name = "teamscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer score;

    private String type;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
