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
import com.ejournal.java.dtos.student.StudentInfoDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.services.StudentService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentInfoDto registerStudent(@Valid @RequestBody StudentRegisterDto studentRegisterDto) {
        return studentService.register(studentRegisterDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public StudentInfoDto getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentInfoDto> getStudents(@RequestParam(required = false) String name, Pageable pageable) {
        return studentService.getStudents(name, pageable);
    }

    @GetMapping("/groups/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentInfoDto> getStudentsByGroup(@PathVariable String id, Pageable pageable) {
        return studentService.getStudentsByGroup(id, pageable);
    }
}
