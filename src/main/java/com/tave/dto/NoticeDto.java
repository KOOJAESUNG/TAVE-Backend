package com.tave.dto;
import com.tave.domain.admin.AdminEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

    private Long id;
    private String content;

    private List<String> images;
    private LocalDateTime dateTime;
    private AdminEntity admin;

}
