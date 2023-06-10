//package com.tave.DtoTest;
//
//import com.tave.domain.member.MemberEntity;
//import com.tave.dto.member.MemberDto;
//import com.tave.mapper.MemberMapper;
//import com.tave.mapper.MemberMapperImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class MemberMapperTest {
//
//    private MemberMapper memberMapper = new MemberMapperImpl();
//
//    @Test
//    public void testEntityToFormDtoMapping() {
//
//        MemberEntity entity = new MemberEntity();
//        entity.setEmail("example@example.com");
//        entity.setPassword("password");
//
//        MemberDto.MemberFormDto formDto = memberMapper.toDto(entity);
//
//        assertNotNull(formDto);
//        assertEquals(entity.getEmail(), formDto.getEmail());
//        assertEquals(entity.getPassword(), formDto.getPassword());
//    }
//
//
//
//    @Test
//    public void testFormDtoToEntityMapping() {
//
//        MemberDto.MemberFormDto formDto = MemberDto.MemberFormDto.builder()
//                .email("example@example.com")
//                .password("password")
//                .build();
//
//        MemberEntity entity = memberMapper.toEntity(formDto);
//
//        assertNotNull(entity);
//        assertEquals(formDto.getEmail(), entity.getEmail());
//        assertEquals(formDto.getPassword(), entity.getPassword());
//    }
//}
