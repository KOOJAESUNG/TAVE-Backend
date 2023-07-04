package com.tave.dto.member;
import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
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

        private String profileImage;

        private Integer rad; //기수

        private String phoneNumber;

        private TechField techField;

        private Long teamId;

        private String university;

        private MemberType memberType; //OB or YB

        private Boolean checkSms;   //false == 첫로그인 true == 이미 인증한사람
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberPatchDto {

        @Email
        private String email;

        private String introduce;

        private String name;

        //비밀번호 정규식. 8~15자 영문, 숫자, 특수문자 조합으로 이뤄져야한다.
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$",
                message = "비밀번호는 8~15자 영문, 숫자, 특수문자 조합이어야 합니다.")
        private String password;

        @PositiveOrZero(message = "기수는 양수여야합니다.")
        private Integer rad; //기수

        //핸드폰번호 정규식. '-'가 있어도 되고 없어도 된다.
        @Pattern(regexp = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$",
                message = "휴대폰 번호를 정확하게 입력해주세요.")
        private String phoneNumber;

        private Long teamId;

        private String university;

        private MemberType memberType; //OB or YB

        private TechField techField; //기술 분야

        private Boolean checkSms;   //false == 첫로그인 true == 이미 인증한사람
    }
}
