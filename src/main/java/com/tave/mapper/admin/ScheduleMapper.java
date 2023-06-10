package com.tave.mapper.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.ScheduleEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.dto.admin.ScheduleDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface ScheduleMapper {

    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(source = "member",target = "member"),
            @Mapping(source = "admin",target = "admin")
    })
    ScheduleEntity toEntity(ScheduleDto.SchedulePostDto schedulePostDto, MemberEntity member, AdminEntity admin);


    @Mappings({
            @Mapping(source = "member.id",target = "memberId"),
            @Mapping(source = "admin.id",target = "adminId")
    })
    ScheduleDto.ScheduleResponseDto toResponseDto(ScheduleEntity scheduleEntity);
}
