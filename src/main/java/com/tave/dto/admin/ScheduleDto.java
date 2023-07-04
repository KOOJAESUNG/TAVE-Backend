package com.tave.dto.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.dto.member.MemberDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchedulePostDto {

        private String place;

        @NotEmpty(message = "Title은 필수값입니다.")
        private String title;

        @NotNull(message = "날짜는 필수값입니다.")
        private LocalDate date;
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

        private Long adminId;

        private List<Long> attendanceMemberId;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchedulePatchDto {

        @NotNull(message = "Schedule ID는 필수값입니다.")
        private Long id;

        private String place;

        private String title;
    }
}
