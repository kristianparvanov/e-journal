package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
public class UnauthorizedException extends RuntimeException {

    public static final String MESSAGE = "You are unauthorized!";

    public UnauthorizedException() {
        super(MESSAGE);
    }
}
