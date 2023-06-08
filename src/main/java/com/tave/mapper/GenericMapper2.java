package com.tave.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @MappingTarget : 변환하여 객체를 return하는 것이 아닌 인자로 받아 업데이트할 target을 설정한다.
 * @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
 *   Source의 필드가 null일 때 정책으로 null인 값은 무시한다.
 * 각 Mapper에서는 GenericMapper을 상속받은 뒤 @Mapper를 선언해주면 된다
 */

public interface GenericMapper2<D, E, D1, E1, D2, E2> {

    D toDto(E e);
    E toEntity(D d);

    D1 toProfileDto(E e);
    E1 toProfileEntity(D d);

    D2 toActiveDto(E e);
    E2 toActiveEntity(D d);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D dto, @MappingTarget E entity);
}
