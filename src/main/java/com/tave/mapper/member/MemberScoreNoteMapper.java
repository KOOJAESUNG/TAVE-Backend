package com.tave.mapper.member;

import com.tave.constant.Type;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.member.MemberScoreNoteEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import com.tave.dto.member.MemberScoreNoteDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface MemberScoreNoteMapper {

    @Mappings({
            @Mapping(source = "memberScoreNotePostDto.type",target = "type",qualifiedByName = "toType"),
            @Mapping(source = "member",target = "member"),
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    MemberScoreNoteEntity toEntity(MemberScoreNoteDto.MemberScoreNotePostDto memberScoreNotePostDto,MemberEntity member);

    @Named("toType")
    public static Type toType(String type) {
        return Type.valueOf(type);
    }


    @Mapping(source = "member.id",target = "memberId")
    MemberScoreNoteDto.MemberScoreNoteResponseDto toResponseDto(MemberScoreNoteEntity memberScoreNoteEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "memberScoreNotePatchDto.type",target = "type",qualifiedByName = "toType"),
            @Mapping(target = "member",ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateFromPatchDto(MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto, @MappingTarget MemberScoreNoteEntity memberScoreNoteEntity);

}
