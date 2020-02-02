package com.ejournal.java.dtos.subjcet;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Data
public class SubjectDto {

    @NotNull
    private Long id;
    private String name;
    private String description;
}
