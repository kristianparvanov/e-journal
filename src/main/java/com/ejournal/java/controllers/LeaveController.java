package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.leave.CreateLeaveDto;
import com.ejournal.java.dtos.leave.LeaveDto;
import com.ejournal.java.dtos.leave.UpdateLeaveDto;
import com.ejournal.java.services.LeaveService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 6.01.20 г.
 */
@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public LeaveDto create(@Valid @RequestBody CreateLeaveDto createLeaveDto) {
        return leaveService.createLeave(createLeaveDto);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public LeaveDto update(@Valid @RequestBody UpdateLeaveDto updateLeaveDto) {
        return leaveService.updateLeave(updateLeaveDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'PARENT', 'STUDENT')")
    public Page<LeaveDto> getByStudent(@RequestParam(required = false) String studentId, Pageable pageable) {
        return leaveService.getByStudent(studentId, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ApiResponseDto deleteLeave(@PathVariable String id) {
        return leaveService.deleteLeave(id);
    }
}
