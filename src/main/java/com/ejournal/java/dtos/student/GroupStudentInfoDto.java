package com.ejournal.java.dtos.student;

import java.util.List;

import com.ejournal.java.dtos.parent.ParentStudentDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 16.02.20 г.
 */
@Data
public class GroupStudentInfoDto {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<ParentStudentDto> parents;
}
