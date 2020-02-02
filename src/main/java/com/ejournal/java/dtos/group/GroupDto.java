package com.ejournal.java.dtos.group;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Data
public class GroupDto {

    @NotNull
    private Long id;
    private Integer level;
    private String name;
    private Integer year;
}
