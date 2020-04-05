package com.ejournal.java.dtos.student;

import java.util.List;

import com.ejournal.java.dtos.group.GroupStudentDto;
import com.ejournal.java.dtos.leave.LeaveStudentDto;
import com.ejournal.java.dtos.mark.MarkStudentDto;
import com.ejournal.java.dtos.parent.ParentStudentDto;
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
    private GroupStudentDto group;
    private List<ParentStudentDto> parents;
    private List<MarkStudentDto> marks;
    private List<LeaveStudentDto> leaves;
}
