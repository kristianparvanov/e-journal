package com.ejournal.java.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.student.StudentInfoDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.entities.Student;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface StudentService {

    StudentInfoDto register(StudentRegisterDto studentRegisterDto);

    Student getById(String id);

    List<Student> getByIdIn(List<String > ids);

    StudentInfoDto getStudent(String id);

    Page<StudentInfoDto> getStudents(String name, Pageable pageable);

    Page<StudentInfoDto> getStudentsByGroup(String id, Pageable pageable);
}
