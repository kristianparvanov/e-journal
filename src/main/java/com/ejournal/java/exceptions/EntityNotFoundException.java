package com.ejournal.java.exceptions;

/**
 * Created by kristiyan.parvanov on 19.01.20 г.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String message) {
        super(message);
    }
}
