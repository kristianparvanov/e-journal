package com.ejournal.java.dtos.teacher;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Data
public class TeacherStudentDto {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean isDirector;
}
