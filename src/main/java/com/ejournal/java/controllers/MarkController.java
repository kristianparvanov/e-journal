package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.mark.CreateMarkDto;
import com.ejournal.java.dtos.mark.MarkDto;
import com.ejournal.java.dtos.mark.UpdateMarkDto;
import com.ejournal.java.services.MarkService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 6.01.20 г.
 */
@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public MarkDto create(@Valid @RequestBody CreateMarkDto createMarkDto) {
        return markService.createMark(createMarkDto);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public MarkDto update(@Valid @RequestBody UpdateMarkDto updateMarkDto) {
        return markService.updateMark(updateMarkDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'PARENT', 'STUDENT')")
    public Page<MarkDto> getByStudent(@RequestParam(required = false) Long studentId, Pageable pageable) {
        return markService.getByStudent(studentId, pageable);
    }
}
