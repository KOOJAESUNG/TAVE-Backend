package com.example.tave.domain.admin;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class NoticeEntity {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateTime;

    @Lob
    private String content;

    @Lob
    private List<String> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;
}
