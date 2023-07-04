package com.tave.dto.team;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

public class TeamDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamPostDto {

        @NotEmpty(message = "Team name은 필수값입니다.")
        private String teamName;

        private Long adminId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamResponseDto {
        private Long id;

        private String teamName;

        private Long adminId;

        private List<Long> memberIds;

        private List<Long> teamScoreNoteIds;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamPatchDto {

        @NotNull(message = "Team ID는 필수값입니다.")
        private Long id;

        private String teamName;

        private Long adminId;

    }
}
