package com.ejournal.java.dtos.teacher;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Getter
@Setter
public class UpdateTeacherDto {

    @NotBlank
    private String id;
    private String schoolId;
    private Boolean isDirector;
}
