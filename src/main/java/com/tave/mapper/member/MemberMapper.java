package com.tave.mapper.member;

import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.member.MemberDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,// 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface MemberMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "profileImage", ignore = true),
            @Mapping(source = "memberPostDto.techField", target = "techField", qualifiedByName = "toTechField"),
            @Mapping(source = "memberPostDto.memberType", target = "memberType", qualifiedByName = "toMemberType"),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "createAt", ignore = true),
            @Mapping(target = "modifiedAt", ignore = true)
    })
    MemberEntity toEntity(MemberDto.MemberPostDto memberPostDto);

    @Mapping(source = "team.id", target = "teamId")
    MemberDto.MemberResponseDto toResponseDto(MemberEntity memberEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "profileImage", ignore = true),
            @Mapping(source = "memberPatchDto.techField", target = "techField", qualifiedByName = "toTechField"),
            @Mapping(source = "memberPatchDto.memberType", target = "memberType", qualifiedByName = "toMemberType"),
            @Mapping(source = "teamEntity", target = "team"),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateFromPatchDto(MemberDto.MemberPatchDto memberPatchDto, TeamEntity teamEntity, @MappingTarget MemberEntity memberEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email",ignore = true),
            @Mapping(target = "introduce",ignore = true),
            @Mapping(target = "name",ignore = true),
            @Mapping(target = "password",ignore = true),
            @Mapping(target = "rad",ignore = true),
            @Mapping(target = "phoneNumber",ignore = true),
            @Mapping(target = "techField",ignore = true),
            @Mapping(target = "memberType",ignore = true),
            @Mapping(target = "team",ignore = true),
            @Mapping(target = "university",ignore = true),
            @Mapping(source = "profileImageURL",target = "profileImage"),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateProfileImage(String profileImageURL, @MappingTarget MemberEntity memberEntity);


    @Named("toTechField")
    public static TechField toTechField(String techField) {
        return TechField.valueOf(techField);
    }

    @Named("toMemberType")
    public static MemberType toMemberType(String memberType) {
        return MemberType.valueOf(memberType);
    }
}
