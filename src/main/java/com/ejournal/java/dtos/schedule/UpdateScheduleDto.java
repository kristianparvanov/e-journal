package com.ejournal.java.dtos.schedule;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 20.02.20 г.
 */
@Data
public class UpdateScheduleDto {

    @NotBlank
    private String id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;

    private String groupId;
}
