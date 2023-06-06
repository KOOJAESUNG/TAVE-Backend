package com.tave.dto;

import com.mysql.cj.protocol.x.Notice;
import com.tave.domain.admin.NoticeEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class NoticeDto {

    private Long id;

    private String noticeName;

    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    public static NoticeDto of(NoticeEntity notice){
        return modelMapper.map(notice, NoticeDto.class);
    }

}
