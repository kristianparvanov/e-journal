package com.ejournal.java.dtos.auhtentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.ejournal.java.annotations.PasswordMatch;
import com.ejournal.java.annotations.ValidPassword;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@PasswordMatch(first = "password", second = "repeatedPassword",  message = "Passwords do not match!")
@Getter
@Setter
public class ChangePasswordDto {

    @NotBlank
    @Email
    private String email;

    @ValidPassword
    private String password;

    private String repeatedPassword;
}
