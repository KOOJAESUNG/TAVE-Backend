package com.tave.dto.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.dto.member.MemberDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

public class ScheduleDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchedulePostDto {
        private String place;
        private String title;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ScheduleResponseDto {
        private Long id;

        private LocalDate date;
        private String place;
        private String title;

        private MemberDto.MemberResponseDto member;

        private AdminDto.AdminResponseDto admin;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchedulePatchDto {

        private Long id;
        private String place;
        private String title;
    }
}
