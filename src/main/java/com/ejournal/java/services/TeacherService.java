package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.teacher.TeacherInfoDto;
import com.ejournal.java.dtos.teacher.TeacherRegisterDto;
import com.ejournal.java.entities.Teacher;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface TeacherService {

    TeacherInfoDto register(TeacherRegisterDto studentRegisterDto);

    Teacher getById(String id);

    TeacherInfoDto getTeacher(String id);

    Page<TeacherInfoDto> getTeachers(String lastName, Pageable pageable);
}
