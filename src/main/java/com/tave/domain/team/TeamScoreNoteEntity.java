package com.tave.domain.team;


import jakarta.persistence.*;

@Entity
public class TeamScoreNoteEntity {
    @Id
    @Column(name = "teamscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer score;

    private String type;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;
}
