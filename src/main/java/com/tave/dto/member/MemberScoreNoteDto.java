package com.tave.dto.member;

import com.tave.constant.Type;
import com.tave.domain.member.MemberScoreEntity;
import jakarta.persistence.*;
import lombok.*;

public class MemberScoreNoteDto { //아마 엑셀파일을 받아서 작업할 것이기 때문에

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNotePostDto {

        private String note; //비고

        private Integer score; //비고에 따른 점수

        private String type; //가감점 타입. String에서 enum으로 변환 로직 필요
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNoteResponseDto {
        private String note; //비고

        private Integer score; //비고에 따른 점수

        private Type type; //가감점 타입
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberScoreNotePatchDto {

        private Long id;

        private String note; //비고

        private Integer score; //비고에 따른 점수

        private String type; //가감점 타입. String에서 enum으로 변환 로직 필요
    }
}
