package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 30.01.20 г.
 */
public class MissingPropertiesException extends RuntimeException {

    public MissingPropertiesException(final String message) {
        super(message);
    }
}
