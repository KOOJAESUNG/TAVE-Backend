package com.tave.dto.member;
import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import lombok.*;



public class MemberDto {

//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    public static class MemberPostDto {
//        private String email;
//
//        private String introduce;
//
//        private String name;
//
//        private String password;
//
//        private Integer rad; //기수
//
//        private String phoneNumber;
//
//        private String university;
//
//        private String memberType; //OB or YB
//
//        private String techField; //기술 분야
//    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberResponseDto {
        private Long id;

        private String username;

        private String email;

        private String introduce;

        private String name;

        private String password;

        private String profileImage;

        private Integer rad; //기수

        private String phoneNumber;

        private TechField techField;

        private Long teamId;

        private String university;

        private MemberType memberType; //OB or YB
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberPatchDto {

        private String email;

        private String introduce;

        private String name;

        private String password;

        private Integer rad; //기수

        private String phoneNumber;

        private Long teamId;

        private String university;

        private String memberType; //OB or YB

        private String techField; //기술 분야
    }
}
