package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDayDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDto;
import com.ejournal.java.dtos.schedule.GetScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDayDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDto;
import com.ejournal.java.services.ScheduleService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDto createSchedule(@Valid @RequestBody CreateScheduleDto createScheduleDto) {
        return scheduleService.createSchedule(createScheduleDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT', 'PARENT')")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDto getSchedule(@PathVariable String id) {
        return scheduleService.getSchedule(id);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDto updateSchedule(@Valid @RequestBody UpdateScheduleDto updateScheduleDto) {
        return scheduleService.updateSchedule(updateScheduleDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto deleteSchedule(@PathVariable String id) {
        return scheduleService.deleteSchedule(id);
    }

    @PostMapping("/day/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDayDto createScheduleDay(@RequestBody CreateScheduleDayDto createScheduleDayDto) {
        return scheduleService.createScheduleDay(createScheduleDayDto);
    }

    @GetMapping("/day")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDayDto getScheduleDay(@Valid GetScheduleDayDto getScheduleDayDto) {
        return scheduleService.getScheduleDay(getScheduleDayDto);
    }

    @PostMapping("/day/update")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDayDto updateScheduleDay(@Valid @RequestBody UpdateScheduleDayDto updateScheduleDayDto) {
        return scheduleService.updateScheduleDay(updateScheduleDayDto);
    }

    @DeleteMapping("/day")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto deleteScheduleDay(@Valid GetScheduleDayDto getScheduleDayDto) {
        return scheduleService.deleteScheduleDay(getScheduleDayDto);
    }
}
