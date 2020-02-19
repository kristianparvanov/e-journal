package com.ejournal.java.exceptions;

import com.ejournal.java.utils.ExceptionMessages;

/**
 * Created by kristiyan.parvanov on 19.01.20 г.
 */
public class EntityExistsException extends RuntimeException {

    public EntityExistsException(final String entityName) {
        super(String.format(ExceptionMessages.ENTITY_EXISTS_MESSAGE_PATTERN, entityName));
    }
}
