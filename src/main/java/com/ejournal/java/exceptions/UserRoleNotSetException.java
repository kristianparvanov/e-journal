package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
public class UserRoleNotSetException extends RuntimeException{

    private static final String message = "User role not set";

    public UserRoleNotSetException() {
        super(message);
    }
}
