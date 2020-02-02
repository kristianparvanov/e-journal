package com.ejournal.java.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Mark;
import com.ejournal.java.entities.Student;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
public interface MarkRepository extends PagingAndSortingRepository<Mark, Long> {

    Page<Mark> getByStudentAndSubject(Student student, Subject subject, Pageable pageable);

    Page<Mark> getByStudentAndModificationDate(Student student, LocalDate modificationDate, Pageable pageable);

    Page<Mark> getByStudentAndModificationDate_Year(Student student, Integer year, Pageable pageable);

    Page<Mark> getByStudent(Student student, Pageable pageable);
}
