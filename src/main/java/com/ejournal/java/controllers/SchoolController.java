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
import com.ejournal.java.dtos.school.CreateSchoolDto;
import com.ejournal.java.dtos.school.SchoolDto;
import com.ejournal.java.services.SchoolService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public SchoolDto createSchool(@Valid @RequestBody CreateSchoolDto createSchoolDto) {
        return schoolService.createSchool(createSchoolDto);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public SchoolDto updateSchool(@Valid @RequestBody SchoolDto schoolDto) {
        return schoolService.updateSchool(schoolDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Page<SchoolDto> getAll(@RequestParam(required = false) String name, Pageable pageable) {
        return schoolService.getSchools(name, pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public SchoolDto getSchool(@PathVariable String id) {
        return schoolService.getSchool(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponseDto deleteSchool(@PathVariable String id) {
        schoolService.deleteSchool(id);

        return new ApiResponseDto(true, "The school is deleted successfully!");
    }
}
