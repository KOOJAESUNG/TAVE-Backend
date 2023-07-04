package com.tave.dto.admin;

import com.tave.constant.Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class MemberScoreNoteDto { //아마 엑셀파일을 받아서 작업할 것이기 때문에

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNotePostDto {

        private String note; //비고

        @NotNull(message = "점수는 필수값입니다.")
        private Integer score; //비고에 따른 점수

        @NotNull(message = "Type은 필수값입니다.")
        private Type type;

        @NotNull(message = "Member ID는 필수값입니다.")
        private Long memberId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNoteResponseDto {

        private Long id;
        private String note; //비고

        private Integer score; //비고에 따른 점수

        private Type type; //가감점 타입

        private Long memberId;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNotePatchDto {

        @NotNull(message = "Member Score Note의 ID는 필수값입니다.")
        private Long id;

        private String note; //비고

        private Integer score; //비고에 따른 점수

        private String type; //enum
    }
}
