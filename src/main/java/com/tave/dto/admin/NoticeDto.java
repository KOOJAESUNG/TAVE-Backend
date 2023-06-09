package com.tave.dto.admin;
import com.tave.domain.admin.AdminEntity;
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

        private List<String> images; //아마 multipartfile로 받을거라 없앨듯

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

        private AdminDto.AdminResponseDto admin;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NoticePatchDto {
        private String content;

        private List<String> images; //아마 multipartfile로 받을거라 없앨듯

    }

}
