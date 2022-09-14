package com.github.juliherms.ms.pet.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundException  extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(NotFoundException.class);

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
        logger.warn(message);
    }
}