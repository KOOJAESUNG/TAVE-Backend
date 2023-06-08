package com.tave.mapper;

import com.tave.domain.member.MemberEntity;
import com.tave.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.lang.reflect.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper2<MemberDto.MemberFormDto, MemberEntity,
        MemberDto.MemberProfileDto, MemberEntity,
        MemberDto.MemberActiveDto, MemberEntity> {

}


