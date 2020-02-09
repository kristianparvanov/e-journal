package com.ejournal.java.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ejournal.java.entities.User;

/**
 * Created by kristiyan.parvanov on 30.11.19 г.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String > {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
