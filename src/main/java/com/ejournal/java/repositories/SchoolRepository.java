package com.ejournal.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.School;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public interface SchoolRepository extends PagingAndSortingRepository<School, String > {

    boolean existsByCityAndName(String city, String name);

    Page<School> findByNameContaining(String name, Pageable pageable);
}
