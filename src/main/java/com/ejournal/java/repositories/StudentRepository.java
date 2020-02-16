package com.ejournal.java.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Student;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, String > {

    String STUDENTS_BY_NAME = "FROM students s "
            + "LEFT JOIN users u ON s.id = u.id "
            + "WHERE UPPER(CONCAT_WS(' ', u.first_name, u.middle_name, u.last_name)) LIKE UPPER(CONCAT('%', :name, '%'))";

    String FIND_STUDENTS_BY_NAME = "SELECT * "
            + STUDENTS_BY_NAME
            + " ORDER BY u.first_name, u.middle_name, u.last_name \n-- #pageable\n";

    String COUNT_FIND_STUDENTS_BY_NAME = "SELECT COUNT(*) " + STUDENTS_BY_NAME;

    boolean existsByEmail(String email);

    List<Student> findByIdIn(List<String> ids);

    @Query(value = FIND_STUDENTS_BY_NAME, countQuery = COUNT_FIND_STUDENTS_BY_NAME, nativeQuery = true)
    Page<Student> findStudentsByName(@Param("name") String name, Pageable pageable);

    Page<Student> findByGroup(Group group, Pageable pageable);
}
