package com.tave.dto;

import com.tave.constant.TechField;
import com.tave.domain.team.TeamEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {

    private Long id;

    private String email;

    private String introduce;

    private String name;

    private String password;

    private String picture; //프로필사진

    private Integer rad; //기수

    private String phoneNum;

    private TechField techField;

    private TeamEntity team;

    private String university;
}
