package com.tave.dto.admin;

import com.tave.constant.ScoreType;
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
        private ScoreType scoreType;

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

        private ScoreType scoreType;

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

        private ScoreType scoreType;

        private Long teamId;
    }
}
