package com.tave.mapper.team;


import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import com.tave.dto.team.TeamDto;
import com.tave.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface TeamMapper {


    @Mappings({
            @Mapping(source = "admin",target = "admin"),
            @Mapping(target = "teamScore",ignore = true),
            @Mapping(target = "members",ignore = true),
            @Mapping(target = "notes",ignore = true)
    })
    TeamEntity toEntity(TeamDto.TeamPostDto teamPostDto, AdminEntity admin);

    @Mappings({
            @Mapping(source = "admin.id", target = "adminId"),
            @Mapping(source = "members", target = "memberIds", qualifiedByName = "membersToMemberIds"),
            @Mapping(source = "notes", target = "teamScoreNoteIds", qualifiedByName = "notesToTeamScoreNoteIds")
    })
    TeamDto.TeamResponseDto toResponseDto(TeamEntity teamEntity);

    @Named("membersToMemberIds")
    public static List<Long> membersToMemberIds(List<MemberEntity> members) {
        List<Long> temp = new ArrayList<>();
        for (MemberEntity m : members) {
            temp.add(m.getId());
        }
        return temp;
    }

    @Named("notesToTeamScoreNoteIds")
    public static List<Long> notesToTeamScoreNoteIds(List<TeamScoreNoteEntity> notes) {
        List<Long> temp = new ArrayList<>();
        for (TeamScoreNoteEntity t : notes) {
            temp.add(t.getId());
        }
        return temp;
    }
}
