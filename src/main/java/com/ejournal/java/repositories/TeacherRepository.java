package com.ejournal.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Teacher;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, String > {

    boolean existsByEmail(String email);

    Page<Teacher> findByLastNameContaining(String lastName, Pageable pageable);
}
