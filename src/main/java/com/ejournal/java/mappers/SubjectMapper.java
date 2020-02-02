package com.ejournal.java.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.ejournal.java.dtos.subjcet.CreateSubjectDto;
import com.ejournal.java.dtos.subjcet.SimpleSubjectDto;
import com.ejournal.java.dtos.subjcet.SubjectDto;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "marks", ignore = true)
    Subject createSubjectDtoToSubject(CreateSubjectDto createSubjectDto);

    SubjectDto subjectToSubjectDto(Subject subject);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "marks", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Subject updateSubject(SubjectDto subjectDto, @MappingTarget Subject subject);

    SimpleSubjectDto subjectToSimpleSubjectDto(Subject subject);
}
