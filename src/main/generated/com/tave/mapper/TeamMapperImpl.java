package com.tave.mapper;

import com.tave.domain.team.TeamEntity;
import com.tave.dto.TeamDto;
import com.tave.dto.TeamDto.TeamDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T00:19:34+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDto toDto(TeamEntity e) {
        if ( e == null ) {
            return null;
        }

        TeamDtoBuilder teamDto = TeamDto.builder();

        teamDto.id( e.getId() );
        teamDto.teamName( e.getTeamName() );
        teamDto.teamScore( e.getTeamScore() );

        return teamDto.build();
    }

    @Override
    public TeamEntity toEntity(TeamDto d) {
        if ( d == null ) {
            return null;
        }

        TeamEntity teamEntity = new TeamEntity();

        teamEntity.setId( d.getId() );
        teamEntity.setTeamName( d.getTeamName() );
        teamEntity.setTeamScore( d.getTeamScore() );

        return teamEntity;
    }

    @Override
    public void updateFromDto(TeamDto dto, TeamEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getTeamName() != null ) {
            entity.setTeamName( dto.getTeamName() );
        }
        if ( dto.getTeamScore() != null ) {
            entity.setTeamScore( dto.getTeamScore() );
        }
    }
}
