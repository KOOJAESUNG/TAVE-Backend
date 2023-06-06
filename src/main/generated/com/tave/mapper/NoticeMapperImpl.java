package com.tave.mapper;

import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.NoticeDto;
import com.tave.dto.NoticeDto.NoticeDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T16:44:25+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class NoticeMapperImpl implements NoticeMapper {

    @Override
    public NoticeEntity toEntity(NoticeDto noticeDto) {
        if ( noticeDto == null ) {
            return null;
        }

        NoticeEntity noticeEntity = new NoticeEntity();

        noticeEntity.setId( noticeDto.getId() );
        noticeEntity.setContent( noticeDto.getContent() );
        noticeEntity.setDateTime( noticeDto.getDateTime() );
        List<String> list = noticeDto.getImages();
        if ( list != null ) {
            noticeEntity.setImages( new ArrayList<String>( list ) );
        }
        noticeEntity.setAdmin( noticeDto.getAdmin() );

        return noticeEntity;
    }

    @Override
    public NoticeDto toDto(NoticeEntity notice) {
        if ( notice == null ) {
            return null;
        }

        NoticeDtoBuilder noticeDto = NoticeDto.builder();

        noticeDto.id( notice.getId() );
        noticeDto.content( notice.getContent() );
        List<String> list = notice.getImages();
        if ( list != null ) {
            noticeDto.images( new ArrayList<String>( list ) );
        }
        noticeDto.dateTime( notice.getDateTime() );
        noticeDto.admin( notice.getAdmin() );

        return noticeDto.build();
    }
}
