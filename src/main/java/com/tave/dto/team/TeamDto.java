package com.tave.dto.team;

import lombok.*;

import java.util.List;

public class TeamDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamPostDto {

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
        private Long id;

        private String teamName;

        private Long adminId;

    }
}
