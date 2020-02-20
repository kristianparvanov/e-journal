package com.ejournal.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.ejournal.java.entities.Parent;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public interface ParentRepository extends PagingAndSortingRepository<Parent, String > {

    String PARENTS_BY_NAME = "FROM teachers t "
            + "LEFT JOIN users u ON t.id = u.id "
            + "WHERE UPPER(CONCAT_WS(' ', u.first_name, u.middle_name, u.last_name)) LIKE UPPER(CONCAT('%', :name, '%'))";

    String FIND_PARENTS_BY_NAME = "SELECT * "
            + PARENTS_BY_NAME
            + " ORDER BY u.first_name, u.middle_name, u.last_name \n-- #pageable\n";

    String COUNT_FIND_PARENTS_BY_NAME = "SELECT COUNT(*) " + PARENTS_BY_NAME;

    @Query(value = FIND_PARENTS_BY_NAME, countQuery = COUNT_FIND_PARENTS_BY_NAME, nativeQuery = true)
    Page<Parent> findParentsByName(@Param("name") String name, Pageable pageable);
}
