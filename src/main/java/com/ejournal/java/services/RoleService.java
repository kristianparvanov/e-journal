package com.ejournal.java.services;

import com.ejournal.java.entities.Role;
import com.ejournal.java.enums.RoleName;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface RoleService {

    Role findByName(RoleName name);
}
