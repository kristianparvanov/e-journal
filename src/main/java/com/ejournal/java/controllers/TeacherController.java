package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.dtos.teacher.TeacherRegisterDto;
import com.ejournal.java.services.StudentService;
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
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto registerStudent(@Valid @RequestBody TeacherRegisterDto teacherRegisterDto) {
        return teacherService.register(teacherRegisterDto);
    }
}
