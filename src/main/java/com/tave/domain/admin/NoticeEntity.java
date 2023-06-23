package com.tave.domain.admin;

import com.tave.dto.admin.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class NoticeEntity {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "notice_images",
            joinColumns = @JoinColumn(name = "notice_id")
    )
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    public void updateNoticeImages(List<String> noticeImages) {
        this.images = noticeImages;
    }
}
