package com.example.tave.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Schedule {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDate date;

    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
}
