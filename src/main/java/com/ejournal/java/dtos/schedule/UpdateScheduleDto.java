package com.ejournal.java.dtos.schedule;

import javax.validation.constraints.NotBlank;

import com.ejournal.java.enums.Term;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 20.02.20 г.
 */
@Data
public class UpdateScheduleDto {

    @NotBlank
    private String id;

    private Term term;

    private String groupId;
}
