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
    date = "2023-06-09T00:19:34+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class NoticeMapperImpl implements NoticeMapper {

    @Override
    public NoticeDto toDto(NoticeEntity e) {
        if ( e == null ) {
            return null;
        }

        NoticeDtoBuilder noticeDto = NoticeDto.builder();

        noticeDto.id( e.getId() );
        noticeDto.content( e.getContent() );
        List<String> list = e.getImages();
        if ( list != null ) {
            noticeDto.images( new ArrayList<String>( list ) );
        }
        noticeDto.dateTime( e.getDateTime() );
        noticeDto.admin( e.getAdmin() );

        return noticeDto.build();
    }

    @Override
    public NoticeEntity toEntity(NoticeDto d) {
        if ( d == null ) {
            return null;
        }

        NoticeEntity noticeEntity = new NoticeEntity();

        noticeEntity.setId( d.getId() );
        noticeEntity.setContent( d.getContent() );
        noticeEntity.setDateTime( d.getDateTime() );
        List<String> list = d.getImages();
        if ( list != null ) {
            noticeEntity.setImages( new ArrayList<String>( list ) );
        }
        noticeEntity.setAdmin( d.getAdmin() );

        return noticeEntity;
    }

    @Override
    public void updateFromDto(NoticeDto dto, NoticeEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getContent() != null ) {
            entity.setContent( dto.getContent() );
        }
        if ( dto.getDateTime() != null ) {
            entity.setDateTime( dto.getDateTime() );
        }
        if ( entity.getImages() != null ) {
            List<String> list = dto.getImages();
            if ( list != null ) {
                entity.getImages().clear();
                entity.getImages().addAll( list );
            }
        }
        else {
            List<String> list = dto.getImages();
            if ( list != null ) {
                entity.setImages( new ArrayList<String>( list ) );
            }
        }
        if ( dto.getAdmin() != null ) {
            entity.setAdmin( dto.getAdmin() );
        }
    }
}
