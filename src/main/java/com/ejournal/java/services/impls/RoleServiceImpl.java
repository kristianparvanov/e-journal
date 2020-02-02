package com.ejournal.java.services.impls;

import javax.management.relation.RoleNotFoundException;

import org.springframework.stereotype.Service;
import com.ejournal.java.entities.Role;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.UserRoleNotSetException;
import com.ejournal.java.repositories.RoleRepository;
import com.ejournal.java.services.RoleService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByName(final RoleName name) {
        return roleRepository.findByName(name)
                .orElseThrow(UserRoleNotSetException::new);
    }
}
