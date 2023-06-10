//package com.tave.DtoTest;
//
//import com.tave.domain.admin.NoticeEntity;
//import com.tave.dto.admin.NoticeDto;
//import com.tave.mapper.NoticeMapper;
//import com.tave.mapper.NoticeMapperImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class NoticeMapperTest {
//    private NoticeMapper noticeMapper = new NoticeMapperImpl();
//
//    @Test
//    public void testEntityToDtoMapping() { //Entity->Dto
//        // Given
//        NoticeEntity noticeEntity = new NoticeEntity();
//        noticeEntity.setId(1L);
//        noticeEntity.setContent("Test Content");
//        // Set other properties
//
//        // When
//        NoticeDto noticeDto = noticeMapper.toDto(noticeEntity);
//
//        // Then
//        assertEquals(1L, noticeDto.getId());
//        assertEquals("Test Content", noticeDto.getContent());
//        // Assert other properties
//    }
//
//    @Test
//    public void testDtoToEntityMapping() { //Dto->Entity
//        // Given
//        NoticeDto noticeDto = new NoticeDto();
//        noticeDto.setId(1L);
//        noticeDto.setContent("Test Content");
//        // Set other properties
//
//        // When
//        NoticeEntity noticeEntity = noticeMapper.toEntity(noticeDto);
//
//        // Then
//        assertEquals(1L, noticeEntity.getId());
//        assertEquals("Test Content", noticeEntity.getContent());
//        // Assert other properties
//    }
//
//}
