package com.tave.dto;

import com.mysql.cj.protocol.x.Notice;
import com.tave.constant.Type;
import com.tave.domain.admin.NoticeEntity;
import com.tave.domain.member.MemberScoreEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Member;

@Getter
@Setter
public class ScoreDto {

    private Long id;

    private Integer score;

    private Type type;

    private static ModelMapper modelMapper = new ModelMapper();

    public static ScoreDto of(MemberScoreEntity memberScore){
        return modelMapper.map(memberScore, ScoreDto.class);
    }

    public static ScoreDto of(TeamScoreNoteEntity teamScore) {
        return modelMapper.map(teamScore, ScoreDto.class);
    }


}


