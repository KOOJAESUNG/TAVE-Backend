package com.tave.dto.admin;
import lombok.*;
import java.util.List;

public class NoticeDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticePostDto {

        private String content;

        private Long adminId;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticeResponseDto {

        private Long id;

        private String content;

        private List<String> images; //uri로 보낼듯

        private Long adminId;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticePatchDto {

        private Long id;
        private String content;

    }

}
