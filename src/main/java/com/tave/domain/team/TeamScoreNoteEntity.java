package com.tave.domain.team;

import com.tave.constant.Type;
import com.tave.domain.TimeStamp;
import com.tave.dto.team.TeamScoreNoteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TeamScoreNoteEntity extends TimeStamp {
    @Id
    @Column(name = "teamscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String note;

    private Integer score = 0;

    @Enumerated(EnumType.STRING)
    private Type type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

}
