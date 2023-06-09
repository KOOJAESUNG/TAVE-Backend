package com.tave.dto.member;

import com.tave.constant.MemberType;
import com.tave.constant.TechField;

import com.tave.domain.team.TeamEntity;
import com.tave.dto.admin.AdminDto;
import com.tave.dto.team.TeamDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;



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

        private TeamDto.TeamResponseDto team;

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

        private String techField; //enum으로 변경해야함

        private Long teamId;

        private String university;
    }



    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberFormDto { //회원가입 --> 아이디 비번을 서버에서 생성하므로 사용하지 않을 것으로 보임.

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
    public static class MemberProfileDto{ //프로필 수정??
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
    public static class MemberActiveDto { //

        private String id;
        private String name;
        private Integer rad; //기수
        private MemberType memberType; //OB,YB

        private Integer memberTotalScore;
        private Integer teamScore;
        private String picture;
        private String content;


    }
}
