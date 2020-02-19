package com.ejournal.java.dtos.dayitem;

import com.ejournal.java.dtos.subjcet.SimpleSubjectDto;
import com.ejournal.java.dtos.teacher.SimpleTeacherDto;
import com.ejournal.java.enums.DayOfWeek;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Data
public class DayItemDto {

    private String id;
    private DayOfWeek dayOfWeek;
    private Integer period;
    private SimpleSubjectDto subject;
    private SimpleTeacherDto teacher;
}
