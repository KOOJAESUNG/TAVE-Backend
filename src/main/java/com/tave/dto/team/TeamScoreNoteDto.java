package com.tave.dto.team;

import com.tave.constant.Type;
import com.tave.domain.team.TeamEntity;
import jakarta.persistence.*;
import lombok.*;

public class TeamScoreNoteDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamScoreNotePostDto {
        private String note;

        private Integer score; //type에 따른 점수

        private String type; //enum으로 변경로직 필요

        private String team;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamScoreNoteResponseDto {
        private Long id;

        private String note;

        private Integer score;

        private Type type;

        private TeamDto.TeamResponseDto team;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamScoreNotePatchDto {
        private Long id;

        private String note;

        private Integer score; //type에 따른 점수

        private String type; //enum으로 변경로직 필요

        private String team;
    }
}
