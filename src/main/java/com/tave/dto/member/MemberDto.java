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


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberProfileDto{ //프로필 수정
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
    public static class MemberHomeActiveDto { //홈화면 정보

        private Long id;
        private String name;
        private Integer rad; //기수
        private MemberType memberType; //OB,YB
        private Integer memberTotalScore;
        private Integer teamScore;
        private String picture;
        private String content;


    }
}
