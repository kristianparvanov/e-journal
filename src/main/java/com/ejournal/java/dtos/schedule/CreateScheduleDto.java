package com.ejournal.java.dtos.schedule;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Data
public class CreateScheduleDto {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;

    @NotBlank
    private String groupId;
}
