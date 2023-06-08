package com.tave.mapper;

import com.tave.domain.member.MemberEntity;
import com.tave.dto.MemberDto.MemberActiveDto;
import com.tave.dto.MemberDto.MemberActiveDto.MemberActiveDtoBuilder;
import com.tave.dto.MemberDto.MemberFormDto;
import com.tave.dto.MemberDto.MemberFormDto.MemberFormDtoBuilder;
import com.tave.dto.MemberDto.MemberProfileDto;
import com.tave.dto.MemberDto.MemberProfileDto.MemberProfileDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T00:19:34+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberFormDto toDto(MemberEntity e) {
        if ( e == null ) {
            return null;
        }

        MemberFormDtoBuilder memberFormDto = MemberFormDto.builder();

        memberFormDto.email( e.getEmail() );
        memberFormDto.password( e.getPassword() );

        return memberFormDto.build();
    }

    @Override
    public MemberEntity toEntity(MemberFormDto d) {
        if ( d == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setEmail( d.getEmail() );
        memberEntity.setPassword( d.getPassword() );

        return memberEntity;
    }

    @Override
    public MemberProfileDto toProfileDto(MemberEntity e) {
        if ( e == null ) {
            return null;
        }

        MemberProfileDtoBuilder memberProfileDto = MemberProfileDto.builder();

        memberProfileDto.id( e.getId() );
        memberProfileDto.name( e.getName() );
        memberProfileDto.email( e.getEmail() );
        memberProfileDto.phoneNum( e.getPhoneNum() );
        memberProfileDto.introduce( e.getIntroduce() );
        memberProfileDto.password( e.getPassword() );
        memberProfileDto.picture( e.getPicture() );
        memberProfileDto.rad( e.getRad() );
        memberProfileDto.techField( e.getTechField() );
        memberProfileDto.university( e.getUniversity() );

        return memberProfileDto.build();
    }

    @Override
    public MemberEntity toProfileEntity(MemberFormDto d) {
        if ( d == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setEmail( d.getEmail() );
        memberEntity.setPassword( d.getPassword() );

        return memberEntity;
    }

    @Override
    public MemberActiveDto toActiveDto(MemberEntity e) {
        if ( e == null ) {
            return null;
        }

        MemberActiveDtoBuilder memberActiveDto = MemberActiveDto.builder();

        if ( e.getId() != null ) {
            memberActiveDto.id( String.valueOf( e.getId() ) );
        }
        memberActiveDto.name( e.getName() );
        memberActiveDto.rad( e.getRad() );
        memberActiveDto.picture( e.getPicture() );

        return memberActiveDto.build();
    }

    @Override
    public MemberEntity toActiveEntity(MemberFormDto d) {
        if ( d == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setEmail( d.getEmail() );
        memberEntity.setPassword( d.getPassword() );

        return memberEntity;
    }

    @Override
    public void updateFromDto(MemberFormDto dto, MemberEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
    }
}
