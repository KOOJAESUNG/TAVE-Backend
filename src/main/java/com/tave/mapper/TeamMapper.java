package com.tave.mapper;


import com.tave.domain.team.TeamEntity;
import com.tave.dto.TeamDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends GenericMapper<TeamDto, TeamEntity>{
}
