package com.tave.domain.admin;

import com.tave.dto.admin.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class NoticeEntity {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String content;

    @Lob
    private List<String> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;


    public void updateFromPatchDto(NoticeDto.NoticePatchDto noticePatchDto) {
        this.content = noticePatchDto.getContent();
        this.images = noticePatchDto.getImages();
    }
}
