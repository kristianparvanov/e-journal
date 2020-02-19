package com.ejournal.java.dtos.schedule;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.enums.DayOfWeek;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class UpdateScheduleDayDto {

    @NotBlank
    private String scheduleId;
    private DayOfWeek dayOfWeek;
    private List<DayItemDto> days;
}
