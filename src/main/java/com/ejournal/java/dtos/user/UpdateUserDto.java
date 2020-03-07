package com.ejournal.java.dtos.user;

import javax.validation.constraints.NotBlank;

import com.ejournal.java.enums.RoleName;
import lombok.Data;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
@Data
public class UpdateUserDto {

    @NotBlank
    private String id;
    private RoleName roleName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
