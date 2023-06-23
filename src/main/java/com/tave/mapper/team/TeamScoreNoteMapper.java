package com.tave.mapper.team;

import com.tave.domain.team.TeamEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import com.tave.dto.team.TeamScoreNoteDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface TeamScoreNoteMapper {

    @Mappings({
            @Mapping(source = "team",target = "team"),
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    TeamScoreNoteEntity toEntity(TeamScoreNoteDto.TeamScoreNotePostDto teamScoreNotePostDto, TeamEntity team);
    @Mapping(source = "team.id",target = "teamId")
    TeamScoreNoteDto.TeamScoreNoteResponseDto toResponseDto(TeamScoreNoteEntity teamScoreNoteEntity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "teamEntity",target = "team"),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateFromPatchDto(TeamScoreNoteDto.TeamScoreNotePatchDto teamScoreNotePatchDto, TeamEntity teamEntity, @MappingTarget TeamScoreNoteEntity teamScoreNoteEntity);
}
