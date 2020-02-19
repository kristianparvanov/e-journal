package com.ejournal.java.services;

import java.util.List;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.dayitem.CreateDayItemDto;
import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.dtos.schedule.GetScheduleDayDto;
import com.ejournal.java.entities.DayItem;
import com.ejournal.java.enums.DayOfWeek;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
public interface DayItemService {

    DayItem buildDayItem(CreateDayItemDto createDayItemDto, DayOfWeek dayOfWeek);

    DayItem get();

    DayItem update();

    void delete(String id);

    List<DayItemDto> saveAll(List<DayItem> dayItems);

    List<DayItemDto> getDayItemDtos(String scheduleId, DayOfWeek dayOfWeek);

    void deleteScheduleDay(String scheduleId, DayOfWeek dayOfWeek);
}
