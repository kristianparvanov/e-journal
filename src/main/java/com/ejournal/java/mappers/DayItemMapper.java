package com.ejournal.java.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ejournal.java.dtos.dayitem.CreateDayItemDto;
import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.entities.DayItem;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = { SubjectMapper.class, TeacherMapper.class })
public interface DayItemMapper {

    DayItemDto dayItemToDayItemDto(DayItem dayItem);

    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    @Mapping(target = "id", ignore = true)
    DayItem createDayItemDtoToDayItem(CreateDayItemDto createDayItemDto);
}
