package com.ejournal.java.dtos.school;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Getter
@Setter
public class CreateSchoolDto {

    @NotBlank
    private String name;

    @NotBlank
    private String city;
}
