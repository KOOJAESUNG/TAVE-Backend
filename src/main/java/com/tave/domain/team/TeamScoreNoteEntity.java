package com.tave.domain.team;

import com.tave.constant.Type;
import com.tave.dto.team.TeamScoreNoteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TeamScoreNoteEntity {
    @Id
    @Column(name = "teamscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String note;

    private Integer score;

    @Enumerated(EnumType.STRING)
    private Type type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;


    public void updateFromPatchDto(TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto, TeamEntity team) {
        this.note = teamScoreNotePatchDto.getNote();
        this.score = teamScoreNotePatchDto.getScore();
        this.type = Type.valueOf(teamScoreNotePatchDto.getType());
        this.team = team;
    }
}
