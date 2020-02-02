package com.ejournal.java.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.ejournal.java.dtos.school.SchoolDto;
import com.ejournal.java.dtos.school.CreateSchoolDto;
import com.ejournal.java.entities.School;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SchoolMapper {

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "student", ignore = true)
    School createSchoolDtoToSchool(CreateSchoolDto createSchoolDto);

    SchoolDto schoolToSchoolDto(School school);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "student", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    School updateSchool(SchoolDto schoolDto, @MappingTarget School school);
}
