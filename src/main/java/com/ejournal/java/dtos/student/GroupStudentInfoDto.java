package com.ejournal.java.dtos.student;

import java.util.List;

import com.ejournal.java.dtos.group.GroupDto;
import com.ejournal.java.dtos.leave.LeaveDto;
import com.ejournal.java.dtos.mark.MarkDto;
import com.ejournal.java.dtos.parent.ParentDto;
import com.ejournal.java.dtos.school.SchoolDto;
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
    private List<ParentDto> parents;
    private List<MarkDto> marks;
    private List<LeaveDto> leaves;
}
