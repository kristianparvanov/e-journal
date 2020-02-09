package com.ejournal.java.dtos.group;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Data
public class CreateGroupDto {

    @NotNull
    @Min(1)
    @Max(12)
    private Integer level;

    @NotBlank
    private String name;

    @NotNull
    @Min(2000)
    private Integer year;

    @NotNull
    private String schoolId;
}
