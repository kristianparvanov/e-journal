package com.ejournal.java.dtos.leave;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Data
public class CreateLeaveDto {

    @NotBlank
    private String subjectId;

    @NotBlank
    private String studentId;

    @NotBlank
    private String teacherId;
}
