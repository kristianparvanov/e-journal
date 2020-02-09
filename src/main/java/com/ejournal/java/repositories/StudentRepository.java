package com.ejournal.java.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ejournal.java.entities.Student;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface StudentRepository extends CrudRepository<Student, String > {

    boolean existsByEmail(String email);

    List<Student> findByIdIn(List<String > ids);
}
