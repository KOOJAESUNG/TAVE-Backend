package com.tave.dto.admin;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class TeamScoreNoteDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamScoreNotePostDto {

        private String note;

        @NotNull(message = "점수는 필수값입니다.")
        private Integer score; //type에 따른 점수

        @NotNull(message = "Type은 필수값입니다.")
        private String type;

        @NotNull(message = "Team ID는 필수값입니다.")
        private Long teamId;
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

        private String type;

        private Long teamId;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamScoreNotePatchDto {

        @NotNull(message = "Team Score Note ID는 필수값입니다.")
        private Long id;

        private String note;

        private Integer score; //type에 따른 점수

        private String type; //enum으로 변경로직 필요

        private Long teamId;
    }
}
