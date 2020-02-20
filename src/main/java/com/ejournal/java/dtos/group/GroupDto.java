package com.ejournal.java.dtos.group;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.ejournal.java.dtos.school.SchoolDto;
import com.ejournal.java.dtos.student.StudentInfoDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Data
public class GroupDto {

    @NotNull
    private String id;
    private Integer level;
    private String name;
    private Integer year;
    private SchoolDto school;
    private List<StudentInfoDto> students;
}
