package com.ejournal.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.School;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public interface GroupRepository extends PagingAndSortingRepository<Group, String > {

    Page<Group> findBySchool(School school, Pageable pageable);
}
