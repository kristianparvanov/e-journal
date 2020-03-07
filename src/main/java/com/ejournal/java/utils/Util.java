package com.ejournal.java.utils;

import java.util.Set;
import java.util.stream.Collectors;

import com.ejournal.java.entities.Role;
import com.ejournal.java.enums.RoleName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by kristiyan.parvanov on 16.02.20 г.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    public static String formatName(final String name) {
        return name.replaceAll("\\s+", "% %");
    }

    public static Set<RoleName> convertSetOfRolesToRoleNames(final Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
