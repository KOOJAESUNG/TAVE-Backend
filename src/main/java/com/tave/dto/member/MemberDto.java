package com.tave.dto.member;
import com.tave.constant.TechField;
import lombok.*;



public class MemberDto {
    //회원가입은 없기때문에 postdto는 없음

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberResponseDto {
        private Long id;

        private String email;

        private String introduce;

        private String name;

        private String password;

        private String picture; //프로필사진. uri로 보낼듯

        private Integer rad; //기수

        private String phoneNumber;

        private TechField techField;

        private Long teamId;

        private String university;


    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberPatchDto {
        private Long id;

        private String email;

        private String introduce;

        private String name;

        private String password;

        private String picture;

        private Integer rad; //기수

        private String phoneNumber;

        private TechField techField;

        private Long teamId;

        private String university;
    }
}
