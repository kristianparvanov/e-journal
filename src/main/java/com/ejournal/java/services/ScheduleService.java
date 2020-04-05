package com.ejournal.java.services;

import java.util.List;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDayDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDto;
import com.ejournal.java.dtos.schedule.GetScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDayDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDto;
import com.ejournal.java.entities.Schedule;
import com.ejournal.java.enums.Term;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
public interface ScheduleService {

    Schedule getById(String id);

    ScheduleDto createSchedule(CreateScheduleDto createScheduleDto);

    ScheduleDto getSchedule(String id);

    ScheduleDto updateSchedule(UpdateScheduleDto updateScheduleDto);

    ApiResponseDto deleteSchedule(String id);

    List<ScheduleDto> getSchedulesByGroup(String groupId, Term term);

    ScheduleDayDto createScheduleDay(CreateScheduleDayDto createScheduleDayDto);

    ScheduleDayDto getScheduleDay(GetScheduleDayDto getScheduleDayDto);

    ScheduleDayDto updateScheduleDay(UpdateScheduleDayDto updateScheduleDayDto);

    ApiResponseDto deleteScheduleDay(GetScheduleDayDto getScheduleDayDto);
}
