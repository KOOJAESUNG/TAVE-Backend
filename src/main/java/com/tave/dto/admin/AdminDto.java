package com.tave.dto.admin;

import com.tave.domain.team.TeamEntity;
import com.tave.dto.team.TeamDto;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class AdminDto {
//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    public static class AdminPostDto {
//
//        private String email;
//
//        private String phoneNumber;
//
//        private String password;
//
//    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AdminResponseDto {
        private Long id;

        private String username;

        private String email;

        private String phoneNumber;

        private List<Long> teamIds;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AdminPatchDto {

        private String email;

        private String phoneNumber;

        private String password;
    }

}
