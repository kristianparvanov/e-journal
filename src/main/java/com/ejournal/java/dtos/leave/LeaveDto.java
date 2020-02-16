package com.ejournal.java.dtos.leave;

import java.time.LocalDate;

import com.ejournal.java.dtos.subjcet.SimpleSubjectDto;
import com.ejournal.java.dtos.teacher.SimpleTeacherDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Data
public class LeaveDto {

    private String id;
    private LocalDate date;
    private SimpleSubjectDto subject;
    private SimpleTeacherDto teacher;
}
