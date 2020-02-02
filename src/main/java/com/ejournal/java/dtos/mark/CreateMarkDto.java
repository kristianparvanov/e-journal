package com.ejournal.java.dtos.mark;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Data
public class CreateMarkDto {

    @NotNull
    @Min(2)
    @Max(6)
    private Integer mark;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long studentId;

    @NotNull
    private Long teacherId;
}
