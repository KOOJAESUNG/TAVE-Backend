package com.tave.mapper;



import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.NoticeDto;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoticeMapper {

    NoticeMapper INSTANCE = Mappers.getMapper(NoticeMapper.class);

    NoticeEntity toEntity(NoticeDto noticeDto); //Dto -> Entity

    NoticeDto toDto(NoticeEntity notice); //Entity -> Dto
}

