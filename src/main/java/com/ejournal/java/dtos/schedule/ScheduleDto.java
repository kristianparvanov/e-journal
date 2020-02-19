package com.ejournal.java.dtos.schedule;

import java.time.LocalDate;
import java.util.List;

import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.dtos.group.GroupDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Data
public class ScheduleDto {

    private String id;
    private LocalDate fromDate;
    private GroupDto group;
    private List<DayItemDto> days;
}
