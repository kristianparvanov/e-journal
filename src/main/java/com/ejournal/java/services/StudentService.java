package com.ejournal.java.services;

import java.util.List;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.entities.Student;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface StudentService {

    ApiResponseDto register(StudentRegisterDto studentRegisterDto);

    Student getById(String id);

    List<Student> getByIdIn(List<String > ids);
}
