package com.ejournal.java.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.ejournal.java.dtos.mark.MarkDto;
import com.ejournal.java.dtos.mark.MarkStudentDto;
import com.ejournal.java.dtos.mark.UpdateMarkDto;
import com.ejournal.java.entities.Mark;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {TeacherMapper.class, SubjectMapper.class})
public interface MarkMapper {

    @Mapping(target = "date", source = "mark.modificationDate")
    MarkDto markToMarkDto(Mark mark);

    @Mapping(target = "date", source = "mark.modificationDate")
    MarkStudentDto markToMarkStudentDto(Mark mark);

    @Mapping(target = "modificationDate", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "student", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Mark updateMark(UpdateMarkDto updateMarkDto, @MappingTarget Mark mark);
}
