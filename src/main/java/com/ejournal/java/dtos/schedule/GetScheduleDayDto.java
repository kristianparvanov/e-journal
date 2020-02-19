package com.ejournal.java.dtos.schedule;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ejournal.java.enums.DayOfWeek;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class GetScheduleDayDto {

    @NotBlank
    private String scheduleId;

    @NotNull
    private DayOfWeek dayOfWeek;
}
