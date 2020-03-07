package com.ejournal.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.ejournal.java.entities.School;
import com.ejournal.java.entities.Teacher;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, String > {

    String TEACHERS_BY_NAME = "FROM teachers t "
            + "LEFT JOIN users u ON t.id = u.id "
            + "WHERE UPPER(CONCAT_WS(' ', u.first_name, u.middle_name, u.last_name)) LIKE UPPER(CONCAT('%', :name, '%')) "
            + "AND is_director = :isDirector ";

    String ORDER_BY_NAMES = "ORDER BY u.first_name, u.middle_name, u.last_name \n-- #pageable\n";

    String FIND_TEACHERS_BY_NAME = "SELECT * " + TEACHERS_BY_NAME + ORDER_BY_NAMES;

    String COUNT_FIND_TEACHERS_BY_NAME = "SELECT COUNT(*) " + TEACHERS_BY_NAME;

    boolean existsByEmail(String email);

    @Query(value = FIND_TEACHERS_BY_NAME, countQuery = COUNT_FIND_TEACHERS_BY_NAME, nativeQuery = true)
    Page<Teacher> findTeachersByName(@Param("name") String name, @Param("isDirector") Boolean isDirector,
                                     Pageable pageable);

    Page<Teacher> findAllByIsDirector(Boolean isDirector, Pageable pageable);

    Page<Teacher> findAllBySchool(School school, Pageable pageable);
}
