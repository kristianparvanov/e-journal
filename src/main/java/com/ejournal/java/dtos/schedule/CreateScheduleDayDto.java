package com.ejournal.java.dtos.schedule;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ejournal.java.dtos.dayitem.CreateDayItemDto;
import com.ejournal.java.enums.DayOfWeek;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class CreateScheduleDayDto {

    @NotBlank
    private String scheduleId;

    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private List<CreateDayItemDto> days;
}
