package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.teacher.TeacherInfoDto;
import com.ejournal.java.dtos.teacher.TeacherRegisterDto;
import com.ejournal.java.dtos.teacher.UpdateTeacherDto;
import com.ejournal.java.services.TeacherService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherInfoDto registerTeacher(@Valid @RequestBody TeacherRegisterDto teacherRegisterDto) {
        return teacherService.register(teacherRegisterDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public TeacherInfoDto getTeacher(@PathVariable String id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public Page<TeacherInfoDto> getTeachers(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) Boolean isDirector,
                                            Pageable pageable) {
        return teacherService.getTeachers(name, isDirector, pageable);
    }

    @GetMapping("/school/{schoolId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Page<TeacherInfoDto> getBySchool(@PathVariable String schoolId, Pageable pageable) {
        return teacherService.getBySchool(schoolId, pageable);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public TeacherInfoDto updateTeacher(@Valid @RequestBody UpdateTeacherDto updateTeacherDto) {
        return teacherService.updateTeacher(updateTeacherDto);
    }
}
