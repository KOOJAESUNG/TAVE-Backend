package com.tave.dto;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private Long id;

    private String teamName;

    private Integer teamScore;
}
