package com.tave.mapper.member;

import com.tave.domain.member.MemberEntity;
import com.tave.dto.member.MemberDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR // 생성자 주입 전략
//        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface MemberMapper {

    @Mapping(source = "team.id",target = "teamId")
    MemberDto.MemberResponseDto toResponseDto(MemberEntity memberEntity);

}
