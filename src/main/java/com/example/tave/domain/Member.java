package com.example.tave.domain;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;
    private String name;

    private String picture; //프로필사진

    private String email;

    @Lob
    private String introduce;

    private Integer rad; //기수

    private String university;

    @Enumerated(EnumType.STRING)
    private TechField techField;

}
