package com.tave.domain.admin;

import com.tave.domain.member.MemberEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDate date;

    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    private AdminEntity admin;
}
