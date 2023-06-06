package com.tave.dto;

import com.tave.constant.MemberType;
import com.tave.constant.TechField;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;



public class MemberDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberFormDto { //회원가입

        @NotEmpty(message = "이메일은 필수 입력 값입니다.")
        @Email(message = "이메일 형식으로 입력해주세요.")
        private String email;

        @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
        @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
        private String password;



    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberProfileDto{
        private Long id;
        private String name;
        private String email;
        private String phoneNum;
        private String introduce;
        private String password;
        private String picture; //프로필사진
        private Integer rad; //기수
        private TechField techField;
        private String university;

    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberActiveDto {

        private String id;
        private String name;
        private Integer rad; //기수
        private MemberType memberType; //OB,YB

        private Integer memberTotalScore;
        private Integer teamScore;
        private String picture;
        private LocalDate date;
        private String content;


    }
}
