package com.tave.dto.admin;
import com.tave.constant.NoticeType;
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

        private Long id;

        private String content;

        private NoticeType noticeType;

    }

}
