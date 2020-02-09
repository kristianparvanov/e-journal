package com.ejournal.java.dtos.mark;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 30.01.20 г.
 */
@Data
public class UpdateMarkDto {

    @NotNull
    private String id;

    @Min(2)
    @Max(6)
    private Integer mark;
}
