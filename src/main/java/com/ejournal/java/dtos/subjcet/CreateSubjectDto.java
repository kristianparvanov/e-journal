package com.ejournal.java.dtos.subjcet;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Getter
@Setter
public class CreateSubjectDto {

    @NotBlank
    private String name;

    private String description;
}
