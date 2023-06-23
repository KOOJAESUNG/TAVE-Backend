package com.tave.mapper.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.admin.NoticeDto;
import org.mapstruct.*;

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
public interface NoticeMapper {
    @Mappings({
            @Mapping(source = "admin", target = "admin"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "images", ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    NoticeEntity toEntity(NoticeDto.NoticePostDto noticePostDto, AdminEntity admin);

    @Mapping(source = "admin.id", target = "adminId")
    NoticeDto.NoticeResponseDto toResponseDto(NoticeEntity noticeEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "admin", ignore = true),
            @Mapping(target = "images", ignore = true),
            @Mapping(target = "createAt",ignore = true),
            @Mapping(target = "modifiedAt",ignore = true)
    })
    public void updateFromPatchDto(NoticeDto.NoticePatchDto noticePatchDto, @MappingTarget NoticeEntity noticeEntity);
}
