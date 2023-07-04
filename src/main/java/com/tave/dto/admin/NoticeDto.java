package com.tave.dto.admin;
import com.tave.constant.NoticeType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class NoticeDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticePostDto {

        private String content;

        @NotNull(message = "Notice Type은 필수값입니다.")
        private NoticeType noticeType;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticeResponseDto {

        private Long id;

        private String content;

        private NoticeType noticeType;

        private List<String> images; //uri로 보낼듯

        private Long adminId;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticePatchDto {

        @NotNull(message = "Notice ID는 필수값입니다.")
        private Long id;

        private String content;

        private NoticeType noticeType;

    }

}
