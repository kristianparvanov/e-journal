package com.ejournal.java.dtos.user;

import java.util.Set;

import com.ejournal.java.enums.RoleName;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
@Data
public class UserDto {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Set<RoleName> roles;
}
