package com.ejournal.java.dtos.schedule;

import java.time.LocalDate;

import com.ejournal.java.dtos.group.GroupDto;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class SimpleScheduleDto {

    private String id;
    private LocalDate fromDate;
    private GroupDto group;
}
