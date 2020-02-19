package com.ejournal.java.exceptions;

import com.ejournal.java.utils.ExceptionMessages;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class UserRoleNotSetException extends RuntimeException{

    public UserRoleNotSetException() {
        super(ExceptionMessages.USER_ROLE_NOT_SET);
    }
}
