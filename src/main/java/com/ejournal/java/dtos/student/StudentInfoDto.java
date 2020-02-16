package com.ejournal.java.dtos.student;

import java.util.List;

import com.ejournal.java.dtos.group.GroupDto;
import com.ejournal.java.dtos.parent.ParentDto;
import com.ejournal.java.dtos.school.SchoolDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 16.02.20 г.
 */
@Data
public class StudentInfoDto {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private SchoolDto school;
    private GroupDto group;
    private List<ParentDto> parents;
}
