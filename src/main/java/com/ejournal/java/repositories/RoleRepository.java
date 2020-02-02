package com.ejournal.java.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ejournal.java.entities.Role;
import com.ejournal.java.enums.RoleName;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
}
