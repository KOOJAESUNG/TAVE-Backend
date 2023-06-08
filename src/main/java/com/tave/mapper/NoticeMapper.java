package com.tave.mapper;




import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.NoticeDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NoticeMapper extends GenericMapper<NoticeDto, NoticeEntity> {


}

