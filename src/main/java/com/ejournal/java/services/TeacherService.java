package com.ejournal.java.services;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.teacher.TeacherRegisterDto;
import com.ejournal.java.entities.Teacher;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface TeacherService {

    ApiResponseDto register(TeacherRegisterDto studentRegisterDto);

    Teacher getById(Long id);
}
