package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.mark.CreateMarkDto;
import com.ejournal.java.dtos.mark.MarkDto;
import com.ejournal.java.dtos.mark.UpdateMarkDto;
import com.ejournal.java.entities.Mark;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
public interface MarkService {

    MarkDto createMark(CreateMarkDto createMarkDto);

    MarkDto updateMark(UpdateMarkDto updateMarkDto);

    Page<MarkDto> getByStudent(String studentId, Pageable pageable);

    Page<MarkDto> getByStudentAndSubject(Subject subject, Pageable pageable);
}
