package com.ejournal.java.exceptions;

import com.ejournal.java.utils.ExceptionMessages;

/**
 * Created by kristiyan.parvanov on 19.01.20 г.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String entityName, final String id) {
        super(String.format(ExceptionMessages.ENTITY_NOT_FOUND_MESSAGE_PATTERN, entityName, id));
    }
}
