package com.ejournal.java.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

    Page<Subject> findByNameContaining(String name, Pageable pageable);
}
