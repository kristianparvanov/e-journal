package com.ejournal.java.dtos.schedule;

import com.ejournal.java.dtos.group.GroupScheduleDto;
import com.ejournal.java.enums.Term;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 19.02.20 г.
 */
@Data
public class SimpleScheduleDto {

    private String id;
    private Term term;
    private GroupScheduleDto group;
}
