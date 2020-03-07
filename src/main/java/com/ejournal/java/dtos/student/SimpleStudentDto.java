package com.ejournal.java.dtos.student;

import com.ejournal.java.dtos.school.SchoolDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
@Data
public class SimpleStudentDto {

    private String id;
    private String firstName;
    private String lastName;
    private SchoolDto school;
}
