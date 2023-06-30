package com.tave.mapper.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.admin.AdminDto;
import org.mapstruct.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

/**
 * @Mapper 애노테이션을 사용해서 MapStruct 클래스라는 것을 알린다.
 * 빌드하게 되면 @Mapper 인터페이스를 찾아서 XXXImpl의 형태로 구현체를 모두 만들게 된다.
 * 이때 componentModel을 spring으로 준다면 생성되는 Impl은 스프링의 싱글톤 빈으로 관리된다. -> @Component가 붙는다.
 */
@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface AdminMapper {

    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "teams", ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    AdminEntity toEntity(AdminDto.AdminPostDto adminPostDto);

    @Mapping(source = "teams", target = "teamIds", qualifiedByName = "teamToId")
    AdminDto.AdminResponseDto toResponseDto(AdminEntity adminEntity);

    @Named("teamToId")
    public static List<Long> teamToId(List<TeamEntity> teams) {
        List<Long> temp = new ArrayList<>();
        for (TeamEntity t : teams) {
            temp.add(t.getId());
        }
        return temp;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "teams",ignore = true),
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateFromPatchDto(AdminDto.AdminPatchDto adminPatchDto, @MappingTarget AdminEntity adminEntity);
}
