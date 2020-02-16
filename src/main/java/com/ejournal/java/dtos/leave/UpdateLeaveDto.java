package com.ejournal.java.dtos.leave;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 30.01.20 г.
 */
@Data
public class UpdateLeaveDto {

    @NotBlank
    private String id;

    @NotBlank
    private String subjectId;
}
