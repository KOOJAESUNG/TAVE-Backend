package com.tave.DtoTest;

import com.tave.domain.team.TeamEntity;
import com.tave.dto.TeamDto;
import com.tave.mapper.TeamMapper;
import com.tave.mapper.TeamMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamMapperTest {
    private TeamMapper teamMapper = new TeamMapperImpl();

    @Test
    public void testEntityToDtoMapping() {
        // Given
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(1L);
        teamEntity.setTeamName("Team A");
        teamEntity.setTeamScore(100);
        // Set other properties

        // When
        TeamDto teamDto = teamMapper.toDto(teamEntity);

        // Then
        assertEquals(1L, teamDto.getId());
        assertEquals("Team A", teamDto.getTeamName());
        assertEquals(100, teamDto.getTeamScore());
        // Assert other properties
    }

    @Test
    public void testDtoToEntityMapping() {
        // Given
        TeamDto teamDto = new TeamDto();
        teamDto.setId(1L);
        teamDto.setTeamName("Team B");
        teamDto.setTeamScore(200);
        // Set other properties

        // When
        TeamEntity teamEntity = teamMapper.toEntity(teamDto);

        // Then
        assertEquals(1L, teamEntity.getId());
        assertEquals("Team B", teamEntity.getTeamName());
        assertEquals(200, teamEntity.getTeamScore());
        // Assert other properties
    }
}
