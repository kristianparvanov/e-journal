package com.ejournal.java.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Leave;
import com.ejournal.java.entities.Student;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
public interface LeaveRepository extends PagingAndSortingRepository<Leave, String > {

    Page<Leave> getByStudentAndSubject(Student student, Subject subject, Pageable pageable);

    Page<Leave> getByStudentAndModificationDate(Student student, LocalDate modificationDate, Pageable pageable);

    Page<Leave> getByStudentAndModificationDate_Year(Student student, Integer year, Pageable pageable);

    Page<Leave> getByStudent(Student student, Pageable pageable);
}
