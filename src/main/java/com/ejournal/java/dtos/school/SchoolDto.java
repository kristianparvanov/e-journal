package com.ejournal.java.dtos.school;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Getter
@Setter
@NoArgsConstructor
public class SchoolDto {

    @NotNull
    private String id;
    private String name;
    private String city;
}
