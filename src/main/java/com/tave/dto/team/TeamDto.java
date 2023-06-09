package com.tave.dto.team;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import com.tave.dto.admin.AdminDto;
import com.tave.dto.member.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamPostDto {

        private String teamName;
        private String adminEmail;
        private List<Long> memberIds = new ArrayList<>(); //멤버 목록
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamResponseDto {
        private Long id;

        private String teamName;

        private Integer teamScore;

        private AdminDto.AdminResponseDto admin;

        private List<MemberDto.MemberResponseDto> members = new ArrayList<>();

        private List<TeamScoreNoteDto.TeamScoreNoteResponseDto> notes = new ArrayList<>();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TeamPatchDto {
        private Long id;

        private String teamName;

        private String adminEmail;

        private List<Long> memberIds = new ArrayList<>(); //멤버 목록
    }

}
