package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.subjcet.CreateSubjectDto;
import com.ejournal.java.dtos.subjcet.SubjectDto;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface SubjectService {

    SubjectDto createSubject(CreateSubjectDto createSubjectDto);

    SubjectDto updateSubject(SubjectDto subjectDto);

    Subject getById(String id);

    SubjectDto getSubject(String id);

    Page<SubjectDto> getAllSubjects(String name, Pageable pageable);

    void deleteSubject(String id);
}
