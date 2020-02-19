package com.ejournal.java.dtos.schedule;

import java.util.List;

import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
@AllArgsConstructor
public class ScheduleDayDto {

    private SimpleScheduleDto schedule;
    private DayOfWeek dayOfWeek;
    private List<DayItemDto> days;
}
