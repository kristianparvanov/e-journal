package com.ejournal.java.dtos.dayitem;

import javax.validation.constraints.NotBlank;

import com.ejournal.java.enums.DayOfWeek;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class CreateDayItemDto {

    private DayOfWeek dayOfWeek;

    private Integer period;

    @NotBlank
    private String scheduleId;

    @NotBlank
    private String subjectId;

    @NotBlank
    private String teacherId;
}
