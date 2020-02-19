package com.ejournal.java.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.ejournal.java.dtos.schedule.ScheduleDto;
import com.ejournal.java.dtos.schedule.SimpleScheduleDto;
import com.ejournal.java.entities.Schedule;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {DayItemMapper.class, GroupMapper.class})
public interface ScheduleMapper {

    ScheduleDto scheduleToScheduleDto(Schedule schedule);

    SimpleScheduleDto scheduleDtoToSimpleScheduleDto(Schedule schedule);
}
