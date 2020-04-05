package com.ejournal.java.dtos.teacher;

import com.ejournal.java.dtos.school.SchoolDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 16.02.20 г.
 */
@Getter
@Setter
public class TeacherInfoDto {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean isDirector;
    private SchoolDto school;
}
