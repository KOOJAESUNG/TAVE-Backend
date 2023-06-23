package com.tave.dto.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.dto.member.MemberDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduleDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchedulePostDto {
        private String place;
        private String title;
        private LocalDate date;

        private Long memberId;

        private Long adminId;
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

        private Long memberId;

        private Long adminId;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;
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
